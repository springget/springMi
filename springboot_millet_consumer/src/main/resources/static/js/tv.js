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
})()

//搜索下拉区域

var search = document.querySelector('.header-search .search-text')
var drop_list = document.querySelector('.header-search .drop_list')
search.onfocus = function () {

    drop_list.className = 'show drop_list';
}
search.onblur = function () {

    drop_list.className = 'no-show';
};

// 文字轮播区域

(function () {
    var wlis = $(".wrap li").height();

    function topScroll() {
        $(".wrap").css({
            "transform": "translate3d(0px, " + (-wlis) + "px, 0px)",
            "transition": "all 1s"
        })
        setTimeout(function () {
            $(".wrap li:first").appendTo($(".wrap"));
            $(".wrap").css({"transform": "translate3d(0,0,0)", "transition": "all 0s"});

        }, 1000);
    }

    setInterval(topScroll, 1200);
})();

(function () {
    var wls = document.querySelectorAll('.wrap li')
    var index = 1;
    var timerId = setInterval(function () {
        for (var i = 0; i < wls.length; i++) {
            wls[i].className = '';
        }
        wls[index].className = 'bgc';
        index++;
        if (index == 7) {
            index = 0;
        }
    }, 1200)
})();


//高清图片滑动区域
(function () {

    var right_1080p = document.querySelector('.picture-4k .right_1080p'),
        left_4k = document.querySelector('.picture-4k .left_4k'),
        l_4k = document.querySelector('.picture-4k .l-4k');
    right_1080p.onmouseover = function () {

        l_4k.className = 'l-4k wd100';
    }

    right_1080p.onmouseout = function () {

        l_4k.className = 'l-4k';
    }

    left_4k.onmouseover = function () {

        l_4k.className = 'l-4k wd0';
    }

    left_4k.onmouseout = function () {

        l_4k.className = 'l-4k';
    }

})();

$(function () {

//呼吸灯轮播图
// 保存元素
    var $carousel1 = $("#carousel1");
// 获取li们
    var $imgLis1 = $("#carousel1 .imgs1 ul li");
// 获取小圆点们
    var $circles1 = $("#circles1 ol li");
    var $leftBtn1 = $("#leftBtn1");
    var $rightBtn1 = $("#rightBtn1");
// 数量
    var amount1 = $circles1.length;
// console.log(amount);


// 定时器
    var timer = setInterval(rightBtnFun1, 3000);
// 鼠标进入carousel 停止
    $carousel1.mouseenter(function () {
// 停止timer
        clearInterval(timer);
    });
// 鼠标离开重新开启
    $carousel1.mouseleave(function () {
// 设表先关
        clearInterval(timer);
// 重新开启
        timer = setInterval(rightBtnFun1, 3000);
    });


// 信号量
    var idx = 0;
// 右按钮点击事件
// 左右按钮防流氓 图片不运动才接收新任务
// 可以将匿名函数提取 将函数名书写在小括号
    $rightBtn1.click(rightBtnFun1);
// rightBtnFun();
// 声明右按钮点击事件
    function rightBtnFun1() {
// 图片在运动，什么事情都不做
        if ($imgLis1.is(":animated")) {
            return;
        }
// 图片不运动，才会执行这些语句
// 老图消失
        $imgLis1.eq(idx).fadeOut(800);
// 信号量改变
        idx++;
// 验证
        if (idx > amount1 - 1) {
            idx = 0;
        }
// 新图淡入
        $imgLis1.eq(idx).fadeIn(1000);
// 小圆点改变
        $circles1.eq(idx).addClass("cur1").siblings().removeClass("cur1");
    }


// 左按钮点击事件
    $leftBtn1.click(function () {
// 图片在不运动才接收新任务
        if (!$imgLis1.is(":animated")) {
// 老图淡入
            $imgLis1.eq(idx).fadeOut(800);
// 信号量改变
            idx--;
            if (idx < 0) {
                idx = amount1 - 1;
            }
// 新图淡入
            $imgLis1.eq(idx).fadeIn(1000);
// 小圆点改变
            $circles1.eq(idx).addClass("cur1").siblings().removeClass("cur1");
        }
    });


// 小圆点鼠标进入事件
// 防流氓 立即触发
    $circles1.mouseenter(function () {
// 老图淡出
        $imgLis1.eq(idx).stop(true).fadeOut(800);
// 信号量改变 $(this)触发 的小圆点
        idx = $(this).index();
// 新图淡入
        $imgLis1.eq(idx).stop(true).fadeIn(1000);
// 小圆点改变
        $(this).addClass("cur1").siblings().removeClass("cur1");
    });
})