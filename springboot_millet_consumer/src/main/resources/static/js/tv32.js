/**
 * Created by yjw on 2018/9/20.
 */
//获取元素
var container = document.querySelector(".wrap-container");
var ul = document.querySelector(".wrap-container ul");
var lis = ul.children;
var imgWidth = 1283;
var left_arr = document.querySelector(".left_arr");
var right_arr = document.querySelector(".right_arr");
var arrow = document.querySelector(".arrow");
var ljdn = document.querySelector(".ljdn");
var wxtp = document.querySelector(".wxtp");
var ul2 = document.querySelector(".beScreen ul");
var li2 = document.querySelector(".beScreen .li1");

//克隆第一个轮播图
ul.appendChild(ul.children[0].cloneNode(true));

//无缝滚动和点击事件
var index = 0;

left_arr.onclick = function () {
  if (index == 0) {
    index = 3;
    ul.style.left = -index * imgWidth + 'px';
  }
  index--;
  animate(ul, -index * (imgWidth + 30) + 30);
}
right_arr.onclick = function () {
  if (index == 3) {
    index = 0;
    ul.style.left = 0;
  }
  index++;
  animate(ul, -index * (imgWidth + 30) + 30);
}

//自动播放
var timerId = setInterval(function () {
  right_arr.onclick();
}, 3500);

container.onmouseover = function () {
  clearInterval(timerId);
  arrow.style.display = 'block';
}

container.onmouseout = function () {
  timerId = setInterval(function () {
    right_arr.onclick();
  }, 3500);
  arrow.style.display = 'none';
}


//  能做显示器部分的JS
ljdn.onclick = function () {
  animate(ul2, 0);
}
wxtp.onclick = function () {
  animate(ul2, -li2.offsetWidth);
}


//轮播图3
var ul3 = document.querySelector(".comfor-wrap ul");
var left_jiantou = document.querySelector(".left_jiantou");
var right_jiantou = document.querySelector(".right_jiantou");
var lis3 = ul3.children;
var pot = document.querySelector(".pots");
var pots = pot.children;


var index1 = 0;
right_jiantou.onclick = function () {
  index1++;
  animate(ul3, -index1 * (lis3[0].offsetWidth + 40) + 40);
  //console.log(index1);
  if (index1 == 3) {
    right_jiantou.style.display = 'none';
  }
  if (index1 != 0) {
    left_jiantou.style.display = 'block';
  }
  for (var i = 0; i < pots.length; i++) {
    pots[i].style.background = '#ccc';
  }
  pots[index1].style.background = '#000';
}

left_jiantou.onclick = function () {
  index1--;
  animate(ul3, -index1 * (lis3[0].offsetWidth + 40) + 40);
  //console.log(index1);
  if (index1 == 0) {
    left_jiantou.style.display = 'none';
  }
  if (index1 != 3) {
    right_jiantou.style.display = 'block';
  }
  for (var i = 0; i < pots.length; i++) {
    pots[i].style.background = '#ccc';
  }
  pots[index1].style.background = '#000';
}
if (index1 == 0) {
  pots[0].style.background = '#000';
}

for (var i = 0; i < pots.length; i++) {
  pots[i].index = i;
  pots[i].onclick = function () {
    for (var i = 0; i < pots.length; i++) {
      pots[i].style.background = '#ccc';
    }
    pots[this.index].style.background = '#000';

    console.log(this.index);
    animate(ul3, -this.index * (lis3[0].offsetWidth + 40) + 40);
  }
}


//transition 部分



document.onscroll = function () {
  var scrollTop = window.pageYOffset || document.documentElement.scrollTop || document.body.scrollTop;
  var w1h2 = document.querySelector(".pink h2");
  var w1ps = document.querySelectorAll(".pink p");

  if (scrollTop >= 800) {
    w1h2.className = 'transi1';
    w1ps[0].className = 'transi2';
    w1ps[1].className = 'transi3';
    w1ps[2].className = 'transi4';
  }

  var rgznh2 = document.querySelector(".pchwall-text h2");
  var rgznp = document.querySelector(".pchwall-text p");

  if (scrollTop >= 1700) {
    rgznh2.className = 'transi1';
    rgznp.className = 'transi2';
  }

  var haokanh2 = document.querySelector(".haokan h2");
  var haokanp = document.querySelector(".haokan p");

  if (scrollTop >= 2800) {
    haokanh2.className = 'transi1';
    haokanp.className = 'transi2';
  }

  var qingxih2 = document.querySelector(".qingxi h2");
  var qingxip = document.querySelector(".qingxi p");
  var qingxilis = document.querySelectorAll(".qingxi li");

  if (scrollTop >= 4400) {
    qingxih2.className = 'transi1';
    qingxip.className = 'transi2';
    //for(var i = 0; i < qingxilis.length; i++) {
    //  if(i == 0) {
    //    qingxilis[i].className = 'width516 transi1';
    //  }else if(i == 1 || i == 2) {
    //    qingxilis[i].className = 'twolines transi'+(i+1);
    //  }else {
    //    qingxilis[i].className = 'transi'+(i+1);
    //  }
    //}

    }
  if (scrollTop >= 4840) {
    for(var i = 0; i < qingxilis.length; i++) {
      if(i == 0) {
        qingxilis[i].className = 'width516 transi1';
      }else if(i == 1 || i == 2) {
        qingxilis[i].className = 'twolines transi'+(i+1);
      }else {
        qingxilis[i].className = 'transi'+(i+1);
      }
    }
  }


  var huyanh2 = document.querySelector(".huyan h2");
  var huyanp = document.querySelector(".huyan p");

  if (scrollTop >= 5700) {
    huyanh2.className = 'transi1';
    huyanp.className = 'transi2';
  }

  var xingnengh2 = document.querySelector(".xingneng h2");
  var xnp = document.querySelector(".xingneng .xnp");
  var xingnenglis = document.querySelectorAll(".xingneng li");

  if (scrollTop >= 6900) {
    xingnengh2.className = 'transi1';
    xnp.className = 'xnp transi2';
  for(var i = 0; i < xingnenglis.length; i++) {
    if (i == 0) {
      xingnenglis[i].className = 'li1 transi3';
    }else {
      xingnenglis[i].className = 'li3 transi'+(i+3);
    }
  }
  }

  var xsqh2 = document.querySelector(".fix-beScreen h2");
  var xsqp = document.querySelector(".fix-beScreen p");
  var xsqul = document.querySelector(".fix-beScreen ul");

  if (scrollTop >= 7900) {
    xsqh2.className = 'transi1';
    xsqp.className = 'xsqp transi2';
    xsqul.className = 'transi3'
  }

  var stereoh2 = document.querySelector(".stereo h2");
  var stereop = document.querySelector(".stereo p");

  if (scrollTop >= 9100 ) {
    stereoh2.className = 'transi1';
    stereop.className = 'transi2';
  }

  var comforh2 = document.querySelector(".text-comfor h2");
  var comforp =document.querySelector(".text-comfor p");
   if (scrollTop >= 10020) {
     comforh2.className = 'transi1';
     comforp.className = 'transi2';
   }

  var vip_img = document.querySelectorAll(".vip img");
  var vip_line = document.querySelectorAll(".vip-line");
  var vip_h2 = document.querySelectorAll(".vip h2");
  var vip_info = document.querySelectorAll(".vip .vip-info");

  if(scrollTop >= 11600) {
    for(var i = 0; i < vip_img.length; i++) {
      vip_img[i].className = 'transi1';
    }
    for(var i = 0; i < vip_line.length; i++) {
      vip_line[i].className = 'vip-line transi2';
    }
    for(var i = 0; i < vip_h2.length; i++) {
      vip_h2[i].className = 'transi3';
    }
    for(var i = 0; i < vip_info.length; i++) {
      vip_info[i].className = 'vip-info transi4'
    }

  }


  var installh2 = document.querySelector(".install-service h2");
  var installp = document.querySelector(".install-service p");
  var installa = document.querySelector(".install-service a");

  if (scrollTop >= 12600) {
    installh2.className = 'transi1';
    installp.className  = 'transi2';
    installa.className = 'transi3';
  }


  var sumlis = document.querySelectorAll(".summary ul li");

  if(scrollTop >= 13640) {
    for(var i = 0; i < sumlis.length; i++) {
      if(i == 4) {
        sumlis[i].className = 'no-right transi'+(i+1)
      }else{
        sumlis[i].className = 'transi'+(i+1)
      }
    }
  }




  // console.log(scrollTop);
}

//点击视屏

var pchwall_btn = document.querySelector(".pchwall-btn");
var click_video = document.querySelector(".click-video");
var cvideo_close = document.querySelector(".cvideo-close span");

pchwall_btn.onclick  = function () {
  click_video.style.display = 'block';
}

cvideo_close.onclick = function () {
  click_video.style.display = 'none';
}


