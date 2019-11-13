var slideNum = 1;

$(document).ready(function(){
    $(".slider_control_next").click(function(){
        if(slideNum < 3){
            $(".slide").animate({left: '-=100%'});
            $(".slider_control_prev").show();
            slideNum += 1;
        }
    });
});

$(document).ready(function(){
    $(".slider_control_prev").click(function(){
        if(slideNum > 1){
            $(".slide").animate({left: '+=100%'});
            slideNum -= 1;
        } 
        if(slideNum <= 1) {
            $(".slider_control_prev").hide();
        }
    });
});

$(document).ready(function(){
    if(slideNum <= 1){
        $(".slider_control_prev").hide();
    }
});

$(document).ready(function(){
    $(".compute").click(function(){
        $.post("/rocket/parameters",
            {
                Vx: $("#Vx").val(),
                mp: $("#mp").val(),
                s1: $("#s1").val(),
                s2: $("#s2").val(),
                w1: $("#w1").val(),
                w2: $("#w2").val()
            },
       function(data,status){
                $("#div").text(data);
        });
    });
});