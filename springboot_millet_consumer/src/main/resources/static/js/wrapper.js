$(function () {

//呼吸灯轮播图
// 保存元素
    var $carousel2 = $("#carousel2");
// 获取li们
    var $imgLis2 = $("#carousel2 .imgs2 ul li");
// 获取小圆点们
    var $circles2 = $("#circles2 ol li");
    var $leftBtn2 = $("#leftBtn2");
    var $rightBtn2 = $("#rightBtn2");
// 数量
    var amount2 = $circles2.length;
// console.log(amount);


// 定时器
    var timer = setInterval(rightBtnFun2, 3000);
// 鼠标进入carousel 停止
    $carousel2.mouseenter(function () {
// 停止timer
        clearInterval(timer);
    });
// 鼠标离开重新开启
    $carousel2.mouseleave(function () {
// 设表先关
        clearInterval(timer);
// 重新开启
        timer = setInterval(rightBtnFun2, 3000);
    });


// 信号量
    var idx = 0;
// 右按钮点击事件
// 左右按钮防流氓 图片不运动才接收新任务
// 可以将匿名函数提取 将函数名书写在小括号
    $rightBtn2.click(rightBtnFun2);
// rightBtnFun();
// 声明右按钮点击事件
    function rightBtnFun2() {
// 图片在运动，什么事情都不做
        if ($imgLis2.is(":animated")) {
            return;
        }
// 图片不运动，才会执行这些语句
// 老图消失
        $imgLis2.eq(idx).fadeOut(800);
// 信号量改变
        idx++;
// 验证
        if (idx > amount2 - 1) {
            idx = 0;
        }
// 新图淡入
        $imgLis2.eq(idx).fadeIn(1000);
// 小圆点改变
        $circles2.eq(idx).addClass("cur2").siblings().removeClass("cur2");
    }


// 左按钮点击事件
    $leftBtn2.click(function () {
// 图片在不运动才接收新任务
        if (!$imgLis2.is(":animated")) {
// 老图淡入
            $imgLis2.eq(idx).fadeOut(800);
// 信号量改变
            idx--;
            if (idx < 0) {
                idx = amount2 - 1;
            }
// 新图淡入
            $imgLis2.eq(idx).fadeIn(1000);
// 小圆点改变
            $circles2.eq(idx).addClass("cur2").siblings().removeClass("cur2");
        }
    });


// 小圆点鼠标进入事件
// 防流氓 立即触发
    $circles2.mouseenter(function () {
// 老图淡出
        $imgLis2.eq(idx).stop(true).fadeOut(800);
// 信号量改变 $(this)触发 的小圆点
        idx = $(this).index();
// 新图淡入
        $imgLis2.eq(idx).stop(true).fadeIn(1000);
// 小圆点改变
        $(this).addClass("cur2").siblings().removeClass("cur2");
    });
});



// 购物车下拉区域
(function () {
    var car = document.querySelector('.cart-mini');
    var drop_car = document.querySelector('.drop_car')
    car.onmouseover = function () {

        drop_car.className = 'show drop_car loading';
    }

    car.onmouseout = function () {
        drop_car.className = 'no-show';
    }
    drop_car.onmouseover = function () {

        drop_car.className = 'show drop_car loading';
    }
    drop_car.onmouseout = function () {

        drop_car.className = 'no-show';
    }
})();




//搜索下拉区域
(function () {
    var search = document.querySelector('.header-search .search-text')
    var drop_list = document.querySelector('.header-search .drop_list')
    search.onfocus = function () {

        drop_list.className = 'show drop_list';
    }
    search.onblur = function () {

        drop_list.className = 'no-show';
    }
})();

//传统轮播图
// function animate(element, target) {
//
//     clearInterval(element.timerId);
//
//     element.timerId = setInterval(function () {
//         //获取当前元素的位置
//         var current = element.offsetLeft;
//
//         //累加小碎步
//
//         var step = (target - current) / 10;
//         step = step > 0 ? Math.ceil(step) : Math.floor(step);
//
//         current += step;
//         element.style.left = current + 'px';
//         if (current == target) {
//             clearInterval(element.timerId);
//         }
//     }, 20)
// }


//获取元素 秒杀区域轮播
//
// var arrow_left = document.querySelector('.arrow-left');
// var arrow_right = document.querySelector('.arrow-right');
// var ul = document.querySelector('.sg-ms-wrap ul');
// var boxWidth = document.querySelector('.sg-ms-wrap .box').offsetWidth;
//
// var index = 0
// arrow_right.onclick = function () {
//
//     index++;
//     animate(ul, -index * boxWidth);
//
// }
// arrow_left.onclick = function () {
//
//     index--;
//     animate(ul, -index * boxWidth + 14);
//
// }

//鼠标移上元素浮动
(function () {
    var plis = document.querySelectorAll('.phone-r ul li');
    var tjlis = document.querySelectorAll('.reco-content li');
    var rplis = document.querySelectorAll('.rp li')

    function shadowShow(s) {
        for (var i = 0; i < s.length; i++) {

            s[i].onmouseover = function () {
                for (var i = 0; i < s.length; i++) {
                    s[i].className = '';
                }
                this.className = 'hover-active';
            }
            s[i].onmouseout = function () {
                this.className = '';
            }
        }
    }

    shadowShow(plis);
    shadowShow(rplis);
    // shadowShow(tjlis);
})();




// 切换页面导航功能

(function () {
        var jdlis = document.querySelectorAll('.jd li'),
            jduls = document.querySelectorAll('.ele ul'),
            znlis = document.querySelectorAll('.zn li'),
            znuls = document.querySelectorAll('.capacity ul'),
            dplis = document.querySelectorAll('.dp li'),
            dplus = document.querySelectorAll('.coll ul'),
            pjlis = document.querySelectorAll('.pj li'),
            pjuls = document.querySelectorAll('.parts ul'),
            zblis = document.querySelectorAll('.zb li'),
            zbuls = document.querySelectorAll('.rim ul');

        function changeUl(element1, element2) {
            for (var i = 0; i < element1.length; i++) {
                element1[i].index = i;
                element1[i].onmouseover = function () {
                    for (var i = 0; i < element1.length; i++) {
                        element1[i].className = '';
                        element2[i].className = 'no_show';
                    }
                    this.className = 'current';
                    element2[this.index].className = 'show';
                }
            }
        }

        changeUl(jdlis, jduls);
        changeUl(znlis, znuls);
        changeUl(dplis, dplus);
        changeUl(pjlis, pjuls);
        changeUl(zblis, zbuls);
    }
)();


// 缓动动画

function animatehd(element, target) {
    clearInterval(element.timerId);

    element.timerId = setInterval(function () {

        // 获取元素当前位置

        var current = element.offsetLeft;

        //累加小碎步

        var step = (target - current) / 10;
        step = step > 0 ? Math.ceil(step) : Math.floor(step);
        current += step;

        element.style.left = current + 'px';

        if (target == current) {
            clearInterval(element.timerId);
        }

    }, 15)
}




(function () {
    var as = document.querySelectorAll('.header-nav .nav-item > a');
    var items = document.querySelectorAll('.nav-item .item-children');
    var menu = document.querySelector('.header_navMenu')

    for (var i = 0; i < as.length - 2; i++) {
        as[i].index = i;
        as[i].onmouseover = function () {
            menu.className = 'header_navMenu show';
            items[this.index].className = 'item-children w1226 item1 show';
        }
    }

    for (var i = 0; i < as.length - 2; i++) {
        as[i].index = i;
        as[i].onmouseout = function () {
            menu.className = 'no-show';
            items[this.index].className = 'item-children w1226 item1 no-show';
        }
    }

})();

// 菜单隐藏下拉区域
(function () {
    var as = document.querySelectorAll('.header-nav .nav-item > a');
    var items = document.querySelectorAll('.nav-item .item-children');
    var menu = document.querySelector('.header_navMenu')

    for (var i = 0; i < as.length - 2; i++) {
        as[i].index = i;
        as[i].onmouseover = function () {
            menu.className = 'header_navMenu show';
            items[this.index].className = 'item-children w1226 item1 show';
        }
    }

    for (var i = 0; i < as.length - 2; i++) {
        as[i].index = i;
        as[i].onmouseout = function () {
            menu.className = 'no-show';
            items[this.index].className = 'item-children w1226 item1 no-show';
        }
    }

})();
