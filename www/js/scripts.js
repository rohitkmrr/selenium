$(document).ready(function() {
		"use strict";
		/* For Side Menu */
		$('.toggle-menu').jPushMenu();
		
		/* For Litebox */
		$('.fancybox').fancybox();
		
		/* For Screenshots Carousel */
		$('.owl-carousel').owlCarousel({
			loop:true,
			margin:1,
			autoplay:false,
			responsiveClass:true,
			responsive:{
				0:{
					items:1,
					nav:false
				},
				600:{
					items:2,
					nav:false
				},
				960:{
					items:3,
					nav:false
				},
				1100:{
					items:5,
					nav:false
				}
		}
		});
	
	
		/* Side Menu Smoot Scroll */
		$('.cbp-spmenu a[href*=#]:not([href=#])').click(function() {
			if (location.pathname.replace(/^\//,'') == this.pathname.replace(/^\//,'') && location.hostname == this.hostname) {
			var target = $(this.hash);
			target = target.length ? target : $('[name=' + this.hash.slice(1) +']');
			if (target.length) {
		$('html,body').animate({
			scrollTop: target.offset().top
			}, 1000);
			return false;
			}
			}
		});
		
		/* For header slider */
		new TiltSlider( document.getElementById( 'slideshow' ) );
		});
		
		/* For WOW effects */
		wow = new WOW(
		  {
			animateClass: 'animated',
			offset:       100
		  }
		);
		wow.init();
		(jQuery);