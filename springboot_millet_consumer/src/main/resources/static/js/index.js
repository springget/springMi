// 小轮播图区域

(function () {


    var boxWidth = document.querySelector('.all-li .box').offsetWidth,
        ul1 = document.querySelector('.all-li .box .go1'),
        ul2 = document.querySelector('.all-li .box .go2'),
        ul3 = document.querySelector('.all-li .box .go3'),
        ul4 = document.querySelector('.all-li .box .go4'),
        dot1 = document.querySelectorAll('#dot-wrapper1 ul li'),
        dot2 = document.querySelectorAll('#dot-wrapper2 ul li'),
        dot3 = document.querySelectorAll('#dot-wrapper3 ul li'),
        dot4 = document.querySelectorAll('#dot-wrapper4 ul li'),
        go_l1 = document.querySelector('.contents-info .arrow a.go-l1'),
        go_r1 = document.querySelector('.contents-info .arrow a.go-r1'),
        go_l2 = document.querySelector('.contents-info .arrow a.go-l2'),
        go_r2 = document.querySelector('.contents-info .arrow a.go-r2'),
        go_l3 = document.querySelector('.contents-info .arrow a.go-l3'),
        go_r3 = document.querySelector('.contents-info .arrow a.go-r3'),
        go_l4 = document.querySelector('.contents-info .arrow a.go-l4'),
        go_r4 = document.querySelector('.contents-info .arrow a.go-r4');
    var i = 0,
        j = 0,
        k = 0,
        z = 0;


    function btn_rclick1(element, box) {
        element.onclick = function () {
            if (i == 2) {
                return;
            }
            i++;
            animatehd(box, -i * boxWidth);

            for (var w = 0; w < dot1.length; w++) {
                dot1[w].className = 'dot-li';
            }
            if (i < dot1.length) {
                dot1[i].className = 'dot-li check';
            }
        }
    }

    function btn_lclick1(element, box) {
        element.onclick = function () {
            if (i == 0) {
                return;
            }
            i--;
            animatehd(box, -i * boxWidth);
            for (var w = 0; w < dot1.length; w++) {
                dot1[w].className = 'dot-li';
            }
            if (i < dot1.length) {
                dot1[i].className = 'dot-li check';
            }
        }
    }

    function btn_rclick2(element, box) {
        element.onclick = function () {

            if (j == 2) {
                return;
            }
            j++;
            animatehd(box, -j * boxWidth);
            for (var w = 0; w < dot2.length; w++) {
                dot2[w].className = 'dot-li';
            }
            if (j < dot2.length) {
                dot2[j].className = 'dot-li check';
            }
        }
    }

    function btn_lclick2(element, box) {
        element.onclick = function () {
            if (j == 0) {
                return;
            }
            j--;
            animatehd(box, -j * boxWidth);
            for (var w = 0; w < dot2.length; w++) {
                dot2[w].className = 'dot-li';
            }
            if (j < dot2.length) {
                dot2[j].className = 'dot-li check';
            }
        }
    }

    function btn_rclick3(element, box) {
        element.onclick = function () {

            if (k == 2) {
                return;
            }
            k++;
            animatehd(box, -k * boxWidth);
            for (var w = 0; w < dot3.length; w++) {
                dot3[w].className = 'dot-li';
            }
            if (k < 3) {
                dot3[k].className = 'dot-li check';
            }
        }
    }

    function btn_lclick3(element, box) {
        element.onclick = function () {
            if (k == 0) {
                return;
            }
            k--;
            animatehd(box, -k * boxWidth);
            for (var w = 0; w < dot3.length; w++) {
                dot3[w].className = 'dot-li';
            }
            if (k < 3) {
                dot3[k].className = 'dot-li check';
            }
        }
    }

    function btn_rclick4(element, box) {
        element.onclick = function () {

            if (z == 2) {
                return;
            }
            z++;
            animatehd(box, -z * boxWidth);
            for (var w = 0; w < dot4.length; w++) {
                dot4[w].className = 'dot-li';
            }
            if (z < dot4.length) {
                dot4[z].className = 'dot-li check';
            }
        }
    }

    function btn_lclick4(element, box) {
        element.onclick = function () {
            if (z == 0) {
                return;
            }
            z--;
            animatehd(box, -z * boxWidth);
            for (var w = 0; w < dot4.length; w++) {
                dot4[w].className = 'dot-li';
            }
            if (z < dot4.length) {
                dot4[z].className = 'dot-li check';
            }
        }
    }

    btn_rclick1(go_r1, ul1);
    btn_lclick1(go_l1, ul1);
    btn_rclick2(go_r2, ul2);
    btn_lclick2(go_l2, ul2);
    btn_rclick3(go_r3, ul3);
    btn_lclick3(go_l3, ul3);
    btn_rclick4(go_r4, ul4);
    btn_lclick4(go_l4, ul4);


    function dotgo1(element, box) {
        for (var i = 0; i < element.length; i++) {
            element[i].index = i;
            element[i].onclick = function () {
                for (var i = 0; i < element.length; i++) {

                    element[i].className = 'dot-li';
                }
                this.className = 'check dot-li';
                index = this.index;
                animatehd(box, -this.index * boxWidth);
            }
        }
    }

    function dotgo2(element, box) {
        for (var j = 0; j < element.length; j++) {
            element[j].index = j;
            element[j].onclick = function () {
                for (var i = 0; i < element.length; i++) {

                    element[i].className = 'dot-li';
                }
                this.className = 'check dot-li';
                index = this.index;
                animatehd(box, -this.index * boxWidth);
            }
        }
    }

    function dotgo3(element, box) {
        for (var k = 0; k < element.length; k++) {
            element[k].index = k;
            element[k].onclick = function () {
                for (var i = 0; i < element.length; i++) {

                    element[i].className = 'dot-li';
                }
                this.className = 'check dot-li';
                index = this.index;
                animatehd(box, -this.index * boxWidth);
            }
        }
    }

    function dotgo4(element, box) {
        for (var z = 0; z < element.length; z++) {
            element[z].index = z;
            element[z].onclick = function () {
                for (var i = 0; i < element.length; i++) {

                    element[i].className = 'dot-li';
                }
                this.className = 'check dot-li';
                index = this.index;
                animatehd(box, -this.index * boxWidth);
            }
        }
    }

    dotgo1(dot1, ul1);
    dotgo2(dot2, ul2);
    dotgo3(dot3, ul3);
    dotgo4(dot4, ul4);

})();

$(function () {
    //呼吸灯轮播图
// 保存元素
    var $carousel = $("#carousel");
// 获取li们
    var $imgLis = $("#carousel .imgs ul li");
// 获取小圆点们
    var $circles = $("#circles ol li");
    var $leftBtn = $("#leftBtn");
    var $rightBtn = $("#rightBtn");
// 数量
    var amount = $circles.length;
// console.log(amount);


// 定时器
    var timer = setInterval(rightBtnFun, 3000);
// 鼠标进入carousel 停止
    $carousel.mouseenter(function () {
// 停止timer
        clearInterval(timer);
    });
// 鼠标离开重新开启
    $carousel.mouseleave(function () {
// 设表先关
        clearInterval(timer);
// 重新开启
        timer = setInterval(rightBtnFun, 3000);
    });


// 信号量
    var idx = 0;
// 右按钮点击事件
// 左右按钮防流氓 图片不运动才接收新任务
// 可以将匿名函数提取 将函数名书写在小括号
    $rightBtn.click(rightBtnFun);
// rightBtnFun();
// 声明右按钮点击事件
    function rightBtnFun() {
// 图片在运动，什么事情都不做
        if ($imgLis.is(":animated")) {
            return;
        }
// 图片不运动，才会执行这些语句
// 老图消失
        $imgLis.eq(idx).fadeOut(800);
// 信号量改变
        idx++;
// 验证
        if (idx > amount - 1) {
            idx = 0;
        }
// 新图淡入
        $imgLis.eq(idx).fadeIn(1000);
// 小圆点改变
        $circles.eq(idx).addClass("cur").siblings().removeClass("cur");
    }


// 左按钮点击事件
    $leftBtn.click(function () {
// 图片在不运动才接收新任务
        if (!$imgLis.is(":animated")) {
// 老图淡入
            $imgLis.eq(idx).fadeOut(800);
// 信号量改变
            idx--;
            if (idx < 0) {
                idx = amount - 1;
            }
// 新图淡入
            $imgLis.eq(idx).fadeIn(1000);
// 小圆点改变
            $circles.eq(idx).addClass("cur").siblings().removeClass("cur");
        }
    });


// 小圆点鼠标进入事件
// 防流氓 立即触发
    $circles.mouseenter(function () {
// 老图淡出
        $imgLis.eq(idx).stop(true).fadeOut(800);
// 信号量改变 $(this)触发 的小圆点
        idx = $(this).index();
// 新图淡入
        $imgLis.eq(idx).stop(true).fadeIn(1000);
// 小圆点改变
        $(this).addClass("cur").siblings().removeClass("cur");
    });
});

// 菜单隐藏下拉区域
(function () {
    var lis = document.querySelectorAll('.header-nav .nav-item');
    // console.log(as);
    var items = document.querySelectorAll('.nav-item .item-children');
    // console.log(items);
    var menu = document.querySelector('.header_navMenu');
    // console.log(menu)
    var $items = $('.nav-item .item-children');
    var $hNav = $('.header_navMenu');
    for (var i = 0; i < lis.length - 2; i++) {
        lis[i].index = i;
        lis[i].onmouseover = function () {
            for (var i = 0; i < lis.length - 2; i++) {
                menu.className = 'header_navMenu show';
                items[this.index].className = 'item-children w1226 show item1';
            }
            // console.log(this.index)
            $hNav.mouseenter(function () {
                $hNav.addClass('show').removeClass('no-show');
                $items.eq(this.index).addClass('show').removeClass('no-show');
            })
        }
    }

    for (var i = 0; i < lis.length - 2; i++) {
        lis[i].index = i;
        lis[i].onmouseout = function () {
            menu.className = 'header_navMenu no-show';
            items[this.index].className = 'item-children w1226 item1 no-show';
        }
    }
})();
