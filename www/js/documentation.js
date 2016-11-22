
$("#search_button").click(function() {

    var search_str=$("#search_val").val().toLowerCase();
    $('.main_content').removeClass("hide");
    $('.element').removeClass("hide");
    $('.noResult').addClass('hide');
    $('.element').each(function(){  
        var str=$(this).find('.heading').html().toLowerCase();

        if(str.search(search_str) == -1) {

            // hide element and parent
            $(this).addClass("hide");
            $(this).parents('.main_content').addClass('hide');
            $(this).parents('.main_content').next('.noResult').removeClass('hide');
            // if parent need to hide
            $(this).parents('.main_content').find('.element').each(function(){
                    // if any one of them is not hide then show parent
                    if(!$(this).hasClass('hide')) {
                         $(this).parents('.main_content').removeClass('hide');
                         $(this).parents('.main_content').next('.noResult').addClass('hide');
                    }
            })
        }
     });

}); 



$("#search_val").keyup(function() {

    var search_str=$("#search_val").val().toLowerCase();
    $('.main_content').removeClass("hide");
    $('.element').removeClass("hide");
    $('.noResult').addClass('hide');
    $('.element').each(function(){  
        var str=$(this).find('.heading').html().toLowerCase();

        if(str.search(search_str) == -1) {

            // hide element and parent
            $(this).addClass("hide");
            $(this).parents('.main_content').addClass('hide');
            $(this).parents('.main_content').next('.noResult').removeClass('hide');
            // if parent need to hide
            $(this).parents('.main_content').find('.element').each(function(){
                    // if any one of them is not hide then show parent
                    if(!$(this).hasClass('hide')) {
                         $(this).parents('.main_content').removeClass('hide');
                         $(this).parents('.main_content').next('.noResult').addClass('hide');
                    }
            })
        }
     });

}); 
