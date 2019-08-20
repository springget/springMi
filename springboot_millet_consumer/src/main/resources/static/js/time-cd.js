(function () {
    setTime();

    function setTime() {

        var timerId = setInterval(function () {
            var h = document.querySelector('.h');
            var m = document.querySelector('.m');
            var s = document.querySelector('.s');

            var nowTime = new Date();
            var setTime = new Date('2018-10-1 10:00:00');

            var time = parseInt(setTime - nowTime) / 1000;

            if (time <= 0){
                time = 0;
                clearInterval(timerId);
            }

            hours = parseInt(time / 3600);
            h.innerHTML = addZero(hours);

            minutes = parseInt(time / 60) % 60;
            m.innerHTML = addZero(minutes);

            seconds = parseInt(time % 60);
            s.innerHTML = addZero(seconds);

        },1000)
    }



    function addZero(n) {
        return n < 10 ? '0' + n : n;
    }
})();
