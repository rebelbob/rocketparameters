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

$(document).ready(function(){
                        $("#choice1").click(function(){
                            choice = "posled";
                            $("#aInput").hide();
                            $("#stup3req").hide();
                            $("#stup3res").hide();
                        });
                        $("#choice2").click(function(){
                            choice = "parallbezpereliva";
                            $("#aInput").show();
                            $("#stup3req").hide();
                            $("#stup3res").hide();
                        });
                        $("#choice3").click(function(){
                            choice = "parallspereliv";
                            $("#aInput").show();
                            $("#stup3req").hide();
                            $("#stup3res").hide();
                        });
                        $("#choice4").click(function(){
                            choice = "trehstuppaket";
                            $("#aInput").show();
                            $("#stup3req").show();
                            $("#stup3res").show();
                        });
                    });


var choice = "posled";

                    $(document).ready(function(){
                      $(".compute").click(function(){
                        $.post("/rocket/parameters",
                        {
                          scheme : choice,
                          H: $("#H").val(),
                          mp: $("#mp").val(),
                          s1: $("#s1").val(),
                          s2: $("#s2").val(),
                          w1: $("#w1").val(),
                          w2: $("#w2").val(),
                          a: $("#a").val(),
                          w3: $("#w3").val(),
                          s3: $("#s3").val()
                        },
                        function(data,status){
                          var list = data.split(',');
                          $("#mb1").text(list[0]);
                          $("#mb2").text(list[1]);
                          $("#mt1").text(list[2]);
                          $("#mt2").text(list[3]);
                          $("#mk1").text(list[4]);
                          $("#mk2").text(list[5]);
                          $("#m0").text(list[6]);
                          $("#mb3").text(list[7]);
                          $("#mt3").text(list[8]);
                          $("#mk3").text(list[9]);
                        });
                      });
                    });


$(document).ready(function(){
                      $(".graph").click(function(){
                        $.post("/rocket/graph",
                        {
                          scheme : choice,
                          P1: $("#P1").val(),
                          P2: $("#P2").val(),
                          P3: $("#P3").val(),
                          t1: $("#t1").val(),
                          t2: $("#t2").val(),
                          t3: $("#t3").val(),
                          D1: $("#D1").val(),
                          D2: $("#D2").val(),
                          D3: $("#D3").val(),
                          fi1: $("#fi1").val(),
                          fi2: $("#fi2").val(),
                          fi3: $("#fi3").val(),
                          betta: $("#betta").val()
                        },
                        function(data,status){
                        });
                      });
                    });

