
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


// var ik_player;

// //this function is called by the API
// function onYouTubeIframeAPIReady() {
//   //creates the player object
//   ik_player = new YT.Player('ik_player_iframe');
       
//   console.log('Video API is loaded');
//   console.log(ik_player);

//   //subscribe to events
//   ik_player.addEventListener("onReady",       "onYouTubePlayerReady");
//   ik_player.addEventListener("onStateChange", "onYouTubePlayerStateChange");
//   console.log('Video API is loaded and reached here');
// }

// function onYouTubePlayerReady() {
//   console.log('Video is ready to play');
// }

// function onYouTubePlayerStateChange(event) {
//   console.log('Video state changed');
// }

// $('.ytp-large-play-button ytp-button').click(function() {
//     alert("show message");
// });