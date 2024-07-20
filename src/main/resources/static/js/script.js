$(document).ready(function () {
  maxh = $(window).height();
  hedderh = $("#header").height();
  height = maxh-hedderh
  $("#main").css("height", height + "px");
});
$(window).resize(function () {
  maxh = $(window).height();
    hedderh = $("#header").height();
    height = maxh-hedderh
    $("#main").css("height", height + "px");
});