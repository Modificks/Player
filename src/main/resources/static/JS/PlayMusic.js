const buttons = document.querySelectorAll('button[data-url]'),
    songs = [],
    player = document.querySelector('.player'),
    title = document.querySelector('.song'),
    audio = document.querySelector('.audio'),
    progressContainer = document.querySelector('.progress-container'),
    progress = document.querySelector('.progress'),
    image = document.querySelector('.image');

buttons.forEach(button => {
    const songUrl = button.getAttribute('data-url'),
        songTitle = button.parentNode.parentNode.querySelector('th:nth-child(2)').innerText;

    songs.push({title: songTitle, url: songUrl});
});

let songIndex = 0;

function loadSong(songIndex) {
    const currentSong = songs[songIndex];

    title.innerHTML = `${currentSong.title} - ${currentSong.artist}`;
    audio.src = currentSong.url;

    audio.onloadedmetadata = function() {
        currentSong.continuity = audio.duration;
        updateProgress();
    };
}

loadSong(songIndex);

function playSong() {
    player.classList.add('play');
    image.src = '../images/other_images/player_page/bar_img/pause.png';
    audio.play();
}

function pauseSong() {
    player.classList.remove('play');
    image.src = '../images/other_images/player_page/bar_img/play.png';
    audio.pause();
}

function toggle() {
    if (audio.paused) {
        playSong();
    } else {
        pauseSong();
    }
}

function nextSong() {
    songIndex++;

    if (songIndex >= songs.length) {
        songIndex = 0;
    }

    loadSong(songIndex);
    playSong();
}

function previousSong() {
    songIndex--;

    if (songIndex < 0) {
        songIndex = songs.length - 1;
    }

    loadSong(songIndex);
    playSong();
}

function updateProgress() {
    const currentSong = songs[songIndex];
    const {currentTime} = audio;

    if (currentSong && currentSong.continuity) {
        const progressPercent = (currentTime / currentSong.continuity) * 100;
        progress.style.width = `${progressPercent}%`;
    }
}

audio.addEventListener('timeupdate', updateProgress);

function setProgress(event) {
    const width = this.clientWidth;
    const clickX = event.offsetX;
    const currentSong = songs[songIndex];

    if (currentSong && currentSong.continuity) {
        audio.currentTime = (clickX / width) * currentSong.continuity;
    }
}

progressContainer.addEventListener('click', setProgress);

buttons.forEach((button, index) => {
    button.addEventListener('click', () => {
        songIndex = index;

        loadSong(songIndex);
        playSong();
    });
});