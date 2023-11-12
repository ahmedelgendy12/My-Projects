$('#warning').hide();
$('#hiding-container').hide();
$('form').submit(requestAPI);

function requestAPI() {
    const genreInput = $('#genre-input').val();
    const cityInput = $('#city-input').val();
    $('#hiding-container').hide();
    $('#results').empty();
    $('#num-of-events').empty();
    if (genreInput === '') {
        $('#warning').text('Search term cannot be empty. Please enter a search term.')
        $('#warning').show();
        $('body').css('margin-bottom', '100%');
    } else if (cityInput === '') {
        $('#warning').text('City cannot be empty. Please enter a city.')
        $('#warning').show();
        $('body').css('margin-bottom', '100%');
    } else {
        $('#warning').hide();
        $('body').css('margin-bottom', '10%');
        $('#hiding-container').show();
        $.ajax({
            type: "GET",
            url: `https://app.ticketmaster.com/discovery/v2/events.json?apikey=W8KLJ3KiVgrPoXNNAbenReqGAuhGnZ1i&sort=date,asc&keyword=${genreInput}&city=${cityInput}`,
            dataType: "json",
            success: function (data) {
                const embedded = data['_embedded'];
                let numOfResults = data['page'].totalElements;
                if (numOfResults > 20) {
                    numOfResults = 20;
                }
                if (numOfResults === 0) {
                    $('#num-of-events').append(`<span class="lead text-danger-emphasis fw-bold">Sorry...No results were found for the entered search term and city.</span>`);
                } else {
                    const events = embedded.events;
                    $('#num-of-events').text(numOfResults + ' events found');
                    $.each(events, function (i, event) {
                        const name = event.name;
                        let imageCorrect = false
                        let x = 0;
                        let highestResIndex = 0;
                        let imageRes = 0;
                        let highestRes = 0;

                        while (x < (event.images).length) {
                            if (event.images[x].ratio === '16_9') {
                                imageRes = event.images[x].width;
                                if (imageRes > highestRes) {
                                    highestResIndex = x;
                                    highestRes = imageRes;
                                }
                            }
                            ++x;

                        }
                        const imageURL = event.images[highestResIndex].url;
                        const startDate = event.dates.start;
                        const dateFormatted = new Date(startDate.dateTime).toDateString();
                        const localTime = startDate.localTime;
                        const timeFormatted = formatTime(localTime);
                        const embedded = event['_embedded'];
                        let spotifyLink = '';
                        let facebookLink = '';
                        let twitterLink = '';
                        if (embedded.attractions !== undefined) {
                            const externalLinks = embedded.attractions[0].externalLinks;
                            if (externalLinks !== undefined && externalLinks.spotify !== undefined) {
                                spotifyLink = externalLinks.spotify[0].url;
                            }
                            if (externalLinks !== undefined && externalLinks.facebook !== undefined) {
                                facebookLink = externalLinks.facebook[0].url;
                            }
                            if (externalLinks !== undefined && externalLinks.twitter !== undefined) {
                                twitterLink = externalLinks.twitter[0].url;

                            }
                        }

                        const venue = embedded.venues[0].name; //error in venues[i]
                        const city = embedded.venues[0].city.name;
                        const state = embedded.venues[0].state.name;
                        const address = embedded.venues[0].address.line1;
                        const ticketLink = event.url;
                        $('#results').append('' +
                            '                <div class="card mb-3 bg-white shadow-lg">\n' +
                            '                    <div class="row g-0">\n' +
                            '                        <div class="col-md-4 align-self-center text-md-start text-center">\n' +
                            `                            <img src="${imageURL}" class="img-fluid w-100 rounded-start" alt="...">\n` +  // back tick notation `` allows you to insert variables
                            '                        </div>\n' +
                            '                        <div class="col-md-8">\n' +
                            '                            <div class="card-body">\n' +
                            '                                <div class="row justify-content-between">\n' +
                            '                                    <div class="col-6">\n' +
                            `                                        <h5 class="card-title ">${name}</h5>\n` +
                            `                                        <h5 class="card-title text-secondary">${venue}</h5>\n` +
                            '                                    </div>\n' +
                            '                                    <div class="col-6 text-end">\n' +
                            `                                        <h5 class="card-title text-success">${dateFormatted}</h5>\n` +
                            `                                        <p class="text-success">${timeFormatted}</p>\n` +
                            '                                    </div>\n' +
                            '                                </div>\n' +
                            ` <div class="row justify-content-between">` +
                            `        <div class="col-6"> ` +
                            `                                <p class="card-text text-secondary">${address} <br> ${city}, ${state}</p>\n` +
                            '\n' +
                            `</div>` +
                            `    <div class="col-6 text-end ">` +
                            `   <a href="${spotifyLink}" class="logo-${i}  ">  <i class="bi bi-spotify"></i></a>` +
                            ` <a href="${facebookLink}" class="facebook-logo-${i}"> <i class="bi bi-facebook"></i></a>` +
                            `<a href="${twitterLink}" class="twitter-logo-${i}"> <i class="bi bi-twitter"></i></a>` +
                            `</div>` +
                            `</div>` +
                            `                                <a href="${ticketLink}">\n` +
                            '                                    <button type="button" class="btn btn-primary mt-3">Find tickets</button>\n' +
                            '                                </a>\n' +
                            '                            </div>\n' +
                            '                        </div>\n' +
                            '                    </div>\n' +
                            '                </div>\n'
                        )

                        if (spotifyLink === '') {
                            $('.logo-' + i).hide();
                        }
                        if (facebookLink === '') {
                            $('.facebook-logo-' + i).hide();
                        }
                        if (twitterLink === '') {
                            $('.twitter-logo-' + i).hide();
                        }

                    });
                }
            },

            error: function (xhr, status, err) {

            }
        });


    }


    $('#genre-input').val('');
    $('#city-input').val('');
    return false;
}


function formatTime(time) {
    let realTime;
    if (time === undefined) {
        realTime = '';
    } else {
        let hour = time.substring(0, 2);
        let amPm = '';
        if (parseInt(hour) > 12) {
            amPm = ' PM'
            let formattedHour = parseInt(hour) - 12;
            if (formattedHour < 10) {
                realTime = '0' + formattedHour + time.substring(2, 5) + amPm;
            } else {
                realTime = formattedHour + time.substring(2, 5) + amPm;
            }
        } else {
            amPm = ' AM'
            let formattedHour = parseInt(hour);
            if (formattedHour < 10) {
                realTime = '0' + formattedHour + time.substring(2, 5) + amPm;
            } else {
                realTime = formattedHour + time.substring(2, 5) + amPm;
            }
        }
    }
    return realTime;
}