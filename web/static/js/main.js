(function ($) {

    "use strict";

    /*-------------------------------------
     Wow js Active
     -------------------------------------*/
    new WOW().init();

    /*-------------------------------------
     jQuery MeanMenu
     -------------------------------------*/
    $('nav#dropdown').meanmenu({siteLogo: "<a href='index.html'><img src='img/logo.png' /></a>"});

    /*-------------------------------------
     Jquery Fixed Header Menu
     -----------------------------------*/
    $(window).scroll(function () {

        var s = $("#sticker");
        var w = $(".wrapper");
        //alert(pos.top);
        var windowpos = $(window).scrollTop();
        if ($(window).width() > 767) {

            if (windowpos > 0) {
                s.addClass("stick");
                var h = $(".header-top-area").outerHeight();
                w.css('padding-top', h + "px");
            } else {
                s.removeClass("stick");
                w.css('padding-top', 0);
            }

        }

    });

    /*-------------------------------------
     jQuery Search Box customization
     -------------------------------------*/
    $(".header-top-search.search-box").on('click', '.search-button', function (event) {

        event.preventDefault();
        var v = $(this).prev('.search-text');
        if (v.hasClass('active')) {
            v.removeClass('active');
        } else {
            v.addClass('active');
        }
        return false;

    });

    /*-------------------------------------
     About Counter
     -------------------------------------*/
    var aboutContainer = $('.about-counter');
    if (aboutContainer.length) {

        aboutContainer.counterUp({
            delay: 50,
            time: 5000
        });

    }

    /*-------------------------------------
     OwlCarousel
     -------------------------------------*/
    $('.rc-carousel').each(function () {

        var carousel = $(this),
            loop = carousel.data('loop'),
            items = carousel.data('items'),
            margin = carousel.data('margin'),
            stagePadding = carousel.data('stage-padding'),
            autoplay = carousel.data('autoplay'),
            autoplayTimeout = carousel.data('autoplay-timeout'),
            smartSpeed = carousel.data('smart-speed'),
            dots = carousel.data('dots'),
            nav = carousel.data('nav'),
            navSpeed = carousel.data('nav-speed'),
            rXsmall = carousel.data('r-x-small'),
            rXsmallNav = carousel.data('r-x-small-nav'),
            rXsmallDots = carousel.data('r-x-small-dots'),
            rSmall = carousel.data('r-small'),
            rSmallNav = carousel.data('r-small-nav'),
            rSmallDots = carousel.data('r-small-dots'),
            rMedium = carousel.data('r-medium'),
            rMediumNav = carousel.data('r-medium-nav'),
            rMediumDots = carousel.data('r-medium-dots');

        carousel.owlCarousel({
            loop: (loop ? true : false),
            items: (items ? items : 4),
            lazyLoad: true,
            margin: (margin ? margin : 0),
            //stagePadding: (stagePadding ? stagePadding : 0),
            autoplay: (autoplay ? true : false),
            autoplayTimeout: (autoplayTimeout ? autoplayTimeout : 1000),
            smartSpeed: (smartSpeed ? smartSpeed : 250),
            dots: (dots ? true : false),
            nav: (nav ? true : false),
            navText: ["<i class='fa fa-angle-left'></i>", "<i class='fa fa-angle-right'></i>"],
            navSpeed: (navSpeed ? true : false),
            responsiveClass: true,
            responsive: {
                0: {
                    items: ( rXsmall ? rXsmall : 1),
                    nav: ( rXsmallNav ? true : false),
                    dots: ( rXsmallDots ? true : false)
                },
                768: {
                    items: ( rSmall ? rSmall : 3),
                    nav: ( rSmallNav ? true : false),
                    dots: ( rSmallDots ? true : false)
                },
                992: {
                    items: ( rMedium ? rMedium : 4),
                    nav: ( rMediumNav ? true : false),
                    dots: ( rMediumDots ? true : false)
                }
            }
        });

    });

    /*-------------------------------------
     On click loadmore functionality
     -------------------------------------*/
    $('.loadmore').on('click', 'a', function (e) {

        e.preventDefault();
        var _this = $(this),
            _parent = _this.parents('.menu-list-wrapper'),
            _target = _parent.find('.menu-list'),
            _set = _target.find('.menu-item.hidden').slice(0, 2); // Herre 2 is the limit
        if (_set.length) {
            _set.animate({opacity: 0});
            _set.promise().done(function () {
                _set.removeClass('hidden');
                _set.show().animate({opacity: 1}, 1000);
            });
        } else {
            _this.text('No more item to display');
        }
        return false;

    });

    /*-------------------------------------
     Jquery Scollup
     -------------------------------------*/
    $.scrollUp({
        scrollText: '<i class="fa fa-arrow-up"></i>',
        easingType: 'linear',
        scrollSpeed: 900,
        animation: 'fade'
    });

    /*-------------------------------------
     Accordion
     -------------------------------------*/
    var accordion = $('#accordion');
    accordion.children('.panel').children('.panel-collapse').each(function () {
        if ($(this).hasClass('in')) {
            $(this).parent('.panel').children('.panel-heading').addClass('active');
        }
    });
    accordion
        .on('show.bs.collapse', function (e) {
            $(e.target).prev('.panel-heading').addClass('active');
        })
        .on('hide.bs.collapse', function (e) {
            $(e.target).prev('.panel-heading').removeClass('active');
        });


    /*----------------------------
     Product Count added spinner
     ------------------------------ */
    var spiner = $('.spinner');
    spiner.find('.btn:first-of-type').on('click', function () {
        var target = $(this).parents('.spinner').find('input');
        target.val(parseInt(target.val(), 10) + 1);
    });
    spiner.find('.btn:last-of-type').on('click', function () {
        var target = $(this).parents('.spinner').find('input');
        target.val(parseInt(target.val(), 10) - 1);
    });

    /*----------------------------
     Google Map activation code
     ------------------------------ */
    if ($('#googleMap').length) {

        var initialize = function () {
            var mapOptions = {
                zoom: 12,
                scrollwheel: true,
                center: new google.maps.LatLng(40.70614846, -73.99223328)
            };

            var map = new google.maps.Map(document.getElementById('googleMap'),
                mapOptions);

            var marker = new google.maps.Marker({
                position: map.getCenter(),
                animation: google.maps.Animation.BOUNCE,
                icon: 'img/map-marker.png',
                map: map
            });

        }
        google.maps.event.addDomListener(window, 'load', initialize);

    }

    /*----------------------------
     Contact Form activation code
     ------------------------------ */
    var contactForm = $('#contact-form');
    if (contactForm.length) {
        contactForm.validator().on('submit', function (e) {

            var $this = $(this),
                $target = contactForm.find(".form-response");
            if (e.isDefaultPrevented()) {
                $target.html("<div class='alert alert-success'><p>Please select all required field.</p></div>");
            } else {

                // ajax call
                $.ajax({
                    url: 'php/form-process.php',
                    type: 'POST',
                    data: contactForm.serialize(),
                    beforeSend: function () {
                        $target.html("<div class='alert alert-info'><p>Loading ...</p></div>");
                    },
                    success: function (text) {
                        if (text == "success") {
                            $this[0].reset();
                            $target.html("<div class='alert alert-success'><p>Message has been sent.</p></div>");
                        } else {
                            $target.html("<div class='alert alert-success'><p>" + text + "</p></div>");
                        }
                    }
                });

                return false;
            }

        });
    }

    /*----------------------------
     Contact Form activation code
     ------------------------------ */
    var checkOutForm = $('#checkoutForm');
    if (checkOutForm.length) {

        checkOutForm.validator().on('submit', function (e) {
            var $this = $(this),
                $target = checkOutForm.find(".form-response");
            if (e.isDefaultPrevented()) {
                $target.html("<div class='alert alert-success'><p>Please select all required field.</p></div>");
            } else {

                // ajax call
                $.ajax({
                    url: 'php/checkout-process.php',
                    type: 'POST',
                    data: checkOutForm.serialize(),
                    beforeSend: function () {
                        $target.html("<div class='alert alert-info'><p>Loading ...</p></div>");
                    },
                    success: function (text) {
                        if (text == "success") {
                            $this[0].reset();
                            $target.html("<div class='alert alert-success'><p>Message has been sent.</p></div>");
                        } else {
                            $target.html("<div class='alert alert-success'><p>" + text + "</p></div>");
                        }
                    }
                });

                return false;
            }
        });

    }
    /*-------------------------------------
     Offcanvas toggle Menu activation code
     -------------------------------------*/
    $('#additional-menu-area').on('click', 'span.side-menu-trigger', function () {

        var $this = $(this),
            wraper = $(this).parents('body').find('>.wraper');
        if ($this.hasClass('open')) {
            document.getElementById('mySidenav').style.width = '0';
            $this.removeClass('open').find('i.fa').removeClass('fa-bars').addClass('fa-bars');
            wraper.removeClass('open');
        } else {
            wraper.addClass('open');
            $this.addClass('open').find('i.fa').removeClass('fa-bars').addClass('fa-bars');
            document.getElementById('mySidenav').style.width = '280px';
        }

    });

    $('#mySidenav').on('click', '.closebtn', function (e) {
        e.preventDefault();
        var $this = $(this),
            wraper = $(this).parents('body').find('>.wraper');
        wraper.removeClass('open');
        document.getElementById('mySidenav').style.width = '0';
        $('#additional-menu-area span.side-menu-trigger').removeClass('open').find('i.fa').removeClass('fa-times').addClass('fa-bars');

    });


    /*-------------------------------------
     Window load function
     -------------------------------------*/
    $(window).on('load', function () {

        // Page Preloader
        $('#preloader').fadeOut('slow', function () {
            $(this).remove();
        });

        //jQuery for Isotope initialization
        var $container = $('#inner-isotope');
        if ($container.length > 0) {
            var $isotope = $container.find('.featuredContainer').isotope({
                filter: '*',
                animationOptions: {
                    duration: 750,
                    easing: 'linear',
                    queue: false
                }
            });

            $container.find('.isotop-classes-tab').on('click', 'a', function () {
                var $this = $(this);
                $this.parent('.isotop-classes-tab').find('a').removeClass('current');
                $this.addClass('current');
                var selector = $this.attr('data-filter');
                $isotope.isotope({
                    filter: selector,
                    animationOptions: {
                        duration: 750,
                        easing: 'linear',
                        queue: false
                    }
                });
                return false;
            });
        }
    });// end window load function


})(jQuery);