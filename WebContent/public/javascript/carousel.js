/**
 * Created by kalin on 2017/4/19.
 */
var container = document.getElementById('container');
var images = document.querySelectorAll('.images');//返回一个包含多张图片的non-live的 NodeList 类型的对象
var spans = document.querySelectorAll('.dot span');
var event_intro = document.getElementsByClassName('event_intro');
var next = document.getElementById('next');
var prev = document.getElementById('prev');
var timer; //设置计时器
var image_index = 0;


//图片和小圆点显示函数
function showImage(index) {
    for (var i = 0; i < images.length; i++) {
        spans[i].index = i;//自定义属性，得到对应下标
        images[i].index = i;
        images[i].style.zIndex = 100 - i;//以图片排列顺序
        images[i].style.opacity = '0';//将所有图片透明度设为0
        spans[i].style.backgroundColor = '#fff';
        event_intro[i].style.display = 'none';
    }
    //将传入参数下标值的图片透明度设为1,小圆点背景填充白色
    images[index].style.opacity = '1';
    spans[index].style.backgroundColor = '#cb3a3a';
    event_intro[index].style.display = 'block';
}

//初始下标为0的图片和圆点的样式
showImage(0);
var count = 0;
//图片轮播函数
function Imagecarouse() {
    if (count % 2 == 0) {
        count = 0;
    }
    image_index = count;
    showImage(count);
    count++;
}

function play() {
    timer = setInterval('Imagecarouse()', 4000);
}
//清除计时器
function stop() {
    clearInterval(timer);
}

//向左点击事件
prev.onclick = function () {
    stop;
    if (count == 0) {
        count = 2;
    }
    count--;
    image_index = count;
    showImage(count);
    play;//重新启动计时器
}

//向右点击事件
next.onclick = function () {
    stop;
    Imagecarouse();
    play;

}

for (var i = 0; i < spans.length; i++) {
    spans[i].onclick = function () {
        stop;
        count = event.target.index;
        image_index = count;// 将当前点击的圆点下标值赋给count
        console.log("span"+image_index);
        showImage(count);
        play;
    };
    //跳轉不同html
    images[i].onclick = function() {
        window.open('./eventDetail?eid=' + image_index);
    };
}


container.onmouseover=stop;
container.onmouseout = play;
play();
