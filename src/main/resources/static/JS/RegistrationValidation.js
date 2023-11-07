let form = document.querySelector('.registration-form'),
    formInputs = document.querySelectorAll('.js-input'),
    inputEmail = document.querySelector('.js-input-email'),
    inputNickname = document.querySelector('.js-input-nickname'),
    inputPassword = document.querySelector('.js-input-password');

function validateEmail(email) {
    let regexp = /^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;

    return regexp.test(String(email).toLowerCase());
}

function validateCountry(country) {
    let regexp = new RegExp('.ru');

    return regexp.test(String(country).toLowerCase());
}

function validateNickname(nickname) {
    let regexp = /^[a-zA-Zа-яА-ЯґҐєЄіІїЇ0-9'.-_₴!@#$%^&*()]{1,15}$/;

    return regexp.test(String(nickname).toLowerCase());
}

function validatePassword(password) {
    let regexp = /^[a-zA-Zа-яА-ЯґҐєЄіІїЇ0-9'.-_₴!@#$%^&*()]+$/;

    return regexp.test(String(password));
}

form.onsubmit = function () {
    let emailValue = inputEmail.value,
        nicknameValue = inputNickname.value,
        passwordValue = inputPassword.value,
        emptyInputs = Array.from(formInputs).filter(input => input.value === '');

    formInputs.forEach(function (input) {
        if (input.value === '') {
            input.classList.add('error');
        } else {
            input.classList.remove('error');
        }
    });

    if (emptyInputs.length !== 0) {

        console.log('inputs not filled');

        return false;
    }

    if (!validateEmail(emailValue)) {

        document.getElementById('emailError').innerText = 'Email must contain <@> and domain';
        inputEmail.classList.add('error');

        return false;

    } else {
        inputEmail.classList.remove('error');
    }

    if (validateCountry(emailValue)) {

        document.getElementById('emailError').innerText = 'It can`t contain .ru';
        inputEmail.classList.add('error');

        return false;

    } else {
        inputEmail.classList.remove('error');
    }

    if (!validateNickname(nicknameValue)) {

        document.getElementById('nicknameError').innerText = 'Nickname length must be up to 15';
        inputNickname.classList.add('error');

        return false;

    } else {
        inputNickname.classList.remove('error');
    }

    if (!validatePassword(passwordValue)) {

        document.getElementById('passwordError').innerText = 'This field must contain at least one symbol';
        inputPassword.classList.add('error');

        return false;

    } else {
        inputPassword.classList.remove('error');
    }
}