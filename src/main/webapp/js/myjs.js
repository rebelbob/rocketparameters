var slideNum = 1;

$(document).ready(function(){
    $(".slider_control_next").click(function(){
        if(slideNum < 5){
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

