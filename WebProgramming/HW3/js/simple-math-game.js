let maximumValue = 10;
let minimumValue = 1;
let minimumResultValue = 1;
let numChoices = 5;
let numArray = [];
let resultValues = 100;
let score = 0;
let scoreTotal = 0;
let counter = 10;
const equation = $('#equation');
let difficultyLevel;
let timerId;
let clicker = 0;

jQuery.easing.def = 'easeIn';

$('#title-animation').animate({"margin-left": '0'}, 'slow');

$('form').click(function () {
    $('#title-animation').animate({top: '-=' + '75px'}, 300);
    $('#title-animation').animate({top: '+=' + '75px'}, 300);
    difficultyLevel = $('input:radio:checked').val();
    if (difficultyLevel === "medium") {
        numChoices = 10;
        minimumResultValue = 100;
        minimumValue = 10;
        maximumValue = 90;
        resultValues = 10000;
        stopCounting();
        fullyReset();
        $('#color-switch').css('background-color', '#f3f3ea');
        $('body').css('background-color', '#c2c062');


    } else if (difficultyLevel === "easy") {
        numChoices = 5;
        minimumResultValue = 1;
        minimumValue = 1;
        maximumValue = 10;
        resultValues = 100;
        $('#color-switch').css('background-color', '#f8f8f8');
        $('body').css('background-color', '#949a8e');
        stopCounting();
        fullyReset();

    } else if (difficultyLevel === "insane") {
        numChoices = 50;
        counter = 10;
        minimumValue = 10;
        maximumValue = 1000;
        resultValues = 1000000;
        $('#timer').text(counter);
        if (clicker++ === 0) {
            timerId = setInterval(startCounting, 1000);
        }
        $('#color-switch').css('background-color', '#fafaf9');
        $('body').css('background-color', '#bf9395');
        fullyReset();
    }
});

equation.append(question());

generateButtons();

$('#reset-button').click(fullyReset);

function stopCounting() {
    counter = -3231322;
    $("#timer").text('');
}

function startCounting() {

    if ($("#timer").text() > 0) {
        $("#timer").text(--counter);
        //  console.log(counter);

    } else if (counter === -3231322) {

    } else {
        $("#timer").text(10);
        $('.grade').text('No Answer');
        $('.grade').css('color', 'grey');
        ++scoreTotal;
        counter = 10;
        reset();
    }
}


function fullyReset() {
    reset();
    score = 0;
    scoreTotal = 0;
    $('.grade').text('');
    $('.score').text('');
}

function reset() {
    equation.text('');
    equation.append(question());
    $('#insert-buttons').text('');
    generateButtons();
    difficultyLevel = $('input:radio:checked').val();
    if (difficultyLevel === "medium") {
        stopCounting();
    } else if (difficultyLevel === "easy") {
        stopCounting();
    } else if (difficultyLevel === "insane") {
        counter = 11;
    }
}

function generateButtons() {
    let checkValue = numArray[0];
    for (let i = 1; i < numChoices; i++) {
        let unique = generateRandomAnswers();
        while (numArray.includes(unique)) {
            unique = generateRandomAnswers();
        }
        numArray[i] = unique;
    }
    numArray.sort(function (a, b) {
        return a - b;
    });
    for (let i = 0; i < numChoices; i++) {
        const button = $('<button>');
        let newButton = numArray[i];
        button.text(newButton);

        button.attr('type', 'button');

        button.addClass('btn btn-primary btn-lg ms-1 mt-2');
        $('#insert-buttons').append(button);


        button.click(function () {

            const result = $('.grade');
            if ((checkValue) === parseInt(button.text())) {
                result.text('Correct!');
                result.css('color', 'green');
                $('.score').text('Score ' + ++score + '/' + ++scoreTotal);
                reset();
            } else {
                result.text('Wrong.' + $('#equation').text() + ' is ' + checkValue);
                result.css('color', 'red');
                $('.score').text('Score ' + score + '/' + ++scoreTotal);
                reset();
            }

        })
    }
}

function question() {
    let x = generateRandomNum();
    let y = generateRandomNum();
    numArray[0] = x * y;
    return x + ' * ' + y;
}

function generateRandomNum() {
    //random numbers between  maximumValue + minimumValue and minimumValue
    return Math.floor(Math.random() * maximumValue) + minimumValue;
}

function generateRandomAnswers() {
    //random numbers between 1 and numChoices
    return Math.floor(Math.random() * resultValues) + minimumResultValue;
}

