/**
 * Created by yjw on 2018/9/16.
 */
// 缓动动画的封装
function animate(element, target) {

  // 开启之前, 清除上一个定时器
  clearInterval(element.timerId);

  // 开启一个新的定时器
  element.timerId = setInterval(function () {

    // 动画三步走
    //1. 获取当前位置
    var current = element.offsetLeft;

    //2. 累加小碎步
    var step = (target - current) / 10;
    step = step > 0 ? Math.ceil(step) : Math.floor(step);
    current += step;

    //3. 重新赋值
    element.style.left = current + 'px';

    //4. 判断 到达目的地 清除定时器
    if (current == target) {
      clearInterval(element.timerId);
    }

  }, 15);

}

