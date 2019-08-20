
$(window).scroll(function () {
    console.log($(window).scrollTop());   // 获取
    //console.log($(window).scrollLeft());   // 获取
})



window.onscroll = function () { //绑定scroll事件

    var t = document.documentElement.scrollTop || document.body.scrollTop; //获取滚动距离
    var selis = document.querySelectorAll(".section-info li"); //查询并定义div元素
    se_control = document.querySelector('.section-control h3'),
        se_video = document.querySelectorAll('.video-txt'),
        hdrtxt1 = document.querySelector('.hdr h2'),
        hdrtxt2 = document.querySelector('.hdr h5'),
        audiotxt1 = document.querySelector('.audio-show h3'),
        audiotxt2 = document.querySelector('.audio-show p'),
        wraptxt1 = document.querySelector('.wrap_channel .wrapper h2'),
        wraptxt2 = document.querySelector('.wrap_channel .wrapper p'),
        cuptxt1 = document.querySelector('.cpu h2'),
        cuptxt2 = document.querySelector('.cpu p'),
        memortxt1 = document.querySelector('.memor h2'),
        memortxt2 = document.querySelector('.memor p'),
        sizetxt1 = document.querySelector('.size h2'),
        sizetxt2 = document.querySelector('.size p'),
        instxt1 = document.querySelector('.ins h2'),
        instxt2 = document.querySelector('.ins p'),
        ins_wrap =document.querySelectorAll('.ins_wrap li'),
        buildstxt1 = document.querySelector('.builds h2'),
        buildstxt2 = document.querySelectorAll('.builds p')
        hinttxt1 = document.querySelector('.hint h2');
        hinttxt2 = document.querySelectorAll('.hint p');
    //4K HDR超高清画质
    if (t >= 350) { //判断
        for (var i = 0; i < selis.length; i++) {
            selis[i].className = 'item-' + (i + 1);
        }
    }

    //PatchWall 人工智能语音系统
    if (t >= 900) { //判断
        se_control.className = 'text-tit item-1';
    }

    if (t >= 1350) { //判断
        for (var i = 0; i < se_video.length; i++) {
            se_video[i].className = 'video-txt item-1';
        }
    }

    if (t >= 2200) {
        hdrtxt1.className = 'item-2';
    }
    if (t >= 2250) {
        hdrtxt2.className = 'item-3';
    }

    if (t >= 3100) {
        audiotxt1.className = 'item-2';
    }
    if (t >= 3150) {
        audiotxt2.className = 'item-3';
    }
    if (t >= 3800) {
        wraptxt1.className = 'item-2'
    }
    if (t >= 3800) {
        wraptxt2.className = 'item-3'
    }
    if (t >= 4450) {
        cuptxt1.className = 'item-2'
    }
    if (t >= 4500) {
        cuptxt2.className = 'item-3'
    }


    if (t >= 4900) {
        memortxt1.className = 'item-2'
    }
    if (t >= 4900) {
        memortxt2.className = 'item-3'
    }


    if (t >= 5800) {
        sizetxt1.className = 'item-2'
    }
    if (t >= 5800) {
        sizetxt2.className = 'item-3'
    }

    if (t >= 6350) {
        instxt1.className = 'item-2'
    }

    if (t >= 6700) { //判断
        for (var i = 0; i < ins_wrap.length; i++) {
            ins_wrap[i].className = 'item-' + (i + 1);
        }
    }

    if (t >= 8150) {
        buildstxt1.className = 'item-2'
    }
    if (t >= 8200) {
        for (var i = 0; i < buildstxt2.length; i++) {
            buildstxt2[i].className = 'item-' + (i + 2);
        }
    }

    if (t >= 8750) {
        hinttxt1.className = 'item-2'
    }
    if (t >= 8800) {
        for (var i = 0; i < hinttxt2.length; i++) {
            hinttxt2[i].className = 'item-' + (i + 2);
        }
    }
}