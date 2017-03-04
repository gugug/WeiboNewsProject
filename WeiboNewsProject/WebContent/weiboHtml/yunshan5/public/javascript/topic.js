/**
 * Created by Administrator on 2017/2/14 0014.
 */

// var h = document.getElementsByClassName("label");
// // var gg = t.childNodes[1].childNodes[0].children;
// // var elesArray=Array.prototype.slice.call(h,0);
// console.log(h.length);
var svg = d3.select("svg")
    margin = 20,
    diameter = +svg.attr("width" ),
    g = svg.append("g").attr("transform", "translate(" + diameter / 2 + "," + diameter / 2 + ")");

var color = d3.scaleLinear()
    .domain([-1, 5])
    .range(["hsl(152,80%,80%)", "hsl(228,30%,40%)"])
    .interpolate(d3.interpolateHcl);

var pack = d3.pack()
    .size([diameter - margin, diameter - margin])
    .padding(2);

var art = d3.select("#artical");
// var art = d3.select("#artical").selectAll("p")
//     .enter().append("p");
//     .text(function(){
//
//         // if(svg.g.text.style.display==="inline")
//         //     return svg.g.text;
//     })

d3.json("../public/data/topic.json", function(error, root) {
    if (error) throw error;

    root = d3.hierarchy(root)
        .sum(function(d) { return d.size; })
        .sort(function(a, b) { return b.value - a.value; });

    var focus = root,
        nodes = pack(root).descendants(),
        view;

    var circle = g.selectAll("circle")
        .data(nodes)
        .enter().append("circle")
        .attr("class", function(d) { return d.parent ? d.children ? "node" : "node node--leaf" : "node node--root"; })
        .style("fill", function(d) { return d.children ? color(d.depth) : null; })
        .on("click", function(d) { if (focus !== d) {zoom(d),d3.event.stopPropagation();} });

    // var show =function(d){
    //     console.log(d.data);
    // };
    var text = g.selectAll("text")
        .data(nodes)
        .enter().append("text")
        .attr("class", "label")
        .style("fill-opacity", function(d) { return d.parent === root ? 1 : 0; })
        .style("display", function(d) { return d.parent === root ? "inline" : "none"; })
        .text(function(d) {
            return d.data.name; });

    // var art = d3.select("#artical");



        // .style("visibility", function(d) { return d.parent === focus ? "visable" : "hidden"; })
        // .text(function(d) {console.log(root);});
    // if(g.text.style.display==="inline")

            // for(var i =0;i<(d.data.children.length);i++){
            //     return(d.data.children[i].name);
            // };});
            // if (d.data.style.display==="none") return "none";});

        // .filter(function(d) { return d.parent === svg.focus || this.style.visibility === "visable"; })
        // .on("start", function(d) { if (d.text.style.display==="inline") this.style.visibility = "visable"; })
        // .on("end", function(d) { if (d.text.style.display==="none") this.style.visibility = "hidden"; });

    var node = g.selectAll("circle,text");

    svg
        .style("background", color(-1))
        .on("click", function() {
            zoom(root);
        });
    // art .selectAll("p")
    //     .data(nodes)
    //     .enter().append("p")
    //     .text(function() {
    //         var fo = zoom(root);
    //         alert(fo.data.name);
    //         // for(var i=0;i<focus.children.length;i++){
    //         //     console.log(i,focus.children[i].data.name);
    //         //     return focus.children[i].data.name;
    //         // };
    //     });
    zoomTo([root.x, root.y, root.r * 2 + margin]);

    function zoom(d) {
        var focus0 = focus;
        focus = d;
        var transition = d3.transition()
            .duration(d3.event.altKey ? 7500 : 750)
            .tween("zoom", function(d) {
                var i = d3.interpolateZoom(view, [focus.x, focus.y, focus.r * 2 + margin]);
                return function(t) { zoomTo(i(t)); };
            });

        transition.selectAll("text")
            .filter(function(d) { return d.parent === focus || this.style.display === "inline"; })
            .style("fill-opacity", function(d) { return d.parent === focus ? 1 : 0; })
            .on("start", function(d) {if (d.parent === focus) this.style.display = "inline"; })
            .on("end", function(d) { if (d.parent !== focus) this.style.display = "none"; });


        // art.selectAll("p")
        //     .text(function(d){
        //         // alert(focus.data.name);
        //         if(d.data.name == focus.data.name){alert(d.data.name);return d.data.name;};
        //     });

        art.selectAll("p")
            .data(nodes)
            .enter().append("p")
            .text(function(d) {
                // alert(focus.data.name);
                if(d.data.name == focus.data.name){return d.data.name;}
                else if (d.data.name != focus.data.name){this.style.visibility="none";};
            // for(var i=0;i<focus.children.length;i++){
            //     console.log(i,focus.children[i].data.name);
            //     return focus.children[i].data.name;
            // };
          });
    }

    function zoomTo(v) {
        var k = diameter / v[2]; view = v;
        node.attr("transform", function(d) { return "translate(" + (d.x - v[0]) * k + "," + (d.y - v[1]) * k + ")"; });
        circle.attr("r", function(d) { return d.r * k; });
    }
    // art
    //     .text(function(){
    //         show(root);
    //     });
    // function show(d) {
    //     var focus0 = focus;
    //     focus = d;
    //     var transition = d3.transition()
    //         .duration(d3.event.altKey ? 7500 : 750)
    //         .tween("zoom", function(d) {
    //             var i = d3.interpolateZoom(view, [focus.x, focus.y, focus.r * 2 + margin]);
    //             return function(t) { zoomTo(i(t)); };
    //         });
    //     transition.selectAll("text")
    //         .filter(function (d) {
    //             return d.parent === focus || this.style.visibility === "visible";
    //         })
    //         .on("start", function (d) {
    //             if (d.parent === focus) this.style.visibility = "visible";
    //         })
    //         .on("end", function (d) {
    //             if (d.parent !== focus) this.style.visibility = "none";
    //         });
    // };
});
