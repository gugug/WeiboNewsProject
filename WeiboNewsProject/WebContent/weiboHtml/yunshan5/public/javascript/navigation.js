/**
 * Created by Administrator on 2017/2/13 0013.
 */

window.onload=function() {
    var Lis = document.getElementsByClassName("item");
    var len = Lis.length;
    var links = document.getElementById("page").getElementsByTagName("a"), find = false;
    var s = location.href;
    console.log(s);
    console.log(links[0].href);
    for (var i = 0; i < links.length; i++) {
        if (links[i] == s) {
            Lis[i].className = "itemselect";
            find = true;
            break;
        }
    };
    for (i = 0; i < len; i++) {
        Lis[i].onmouseover = function () {
            this.className = "itemselect";
        };
        Lis[i].onmouseout = function () {
            this.className = "item";
        };
    }

}
