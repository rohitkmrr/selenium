var app= angular.module('documentation',['ngSanitize' ] );

app.controller('selectTabs',['$scope', '$sce', function($scope ,$sce) {
 
    $scope.show1=true;
    $scope.show2=false;
    $scope.show3=false;
    $scope.give1=true;
    $scope.give2=false;
    $scope.give3=false;
    $scope.showWeb=1;
    $scope.showiOS=0;
    $scope.showAndroid=0;
    $scope.showWebElements = function() {
        $scope.show1=true;
        $scope.show2=false;
        $scope.show3=false;
        $scope.showWeb=1;
        $scope.showiOS=0;
        $scope.showAndroid=0;
        $scope.give1=true;
        $scope.give2=false;
        $scope.give3=false;
        if($('.web').hasClass('hide')){
            $scope.show1=true;
           
        }
    };
    $scope.showiOSElements = function() {
        $scope.show1=false;
        $scope.show2=true;
        $scope.show3=false;
        $scope.showWeb=0;
        $scope.showiOS=1;
        $scope.showAndroid=0;
        $scope.give1=false;
        $scope.give2=true;
        $scope.give3=false;
        if($('.ios').hasClass('hide')){
             $scope.show2=true;
              
        }
    };
    $scope.showAndroidElements = function() {
        $scope.show1=false;
        $scope.show2=false;
        $scope.show3=true;
        $scope.showWeb=0;
        $scope.showiOS=0;
        $scope.showAndroid=1;
        $scope.give1=false;
        $scope.give2=false;
        $scope.give3=true; 
        if($('.android').hasClass('hide')){
            $scope.show3=true;
        }
    };
    var BASE_URL = 'https://www.youtube.com/embed/';
    $scope.showModal= function (video_id,heading) {
        $scope.link= BASE_URL+video_id;
        $scope.youtube = $sce.trustAsHtml('<iframe id="ik_player_iframe" width="100%" height="100%" src="'+$scope.link+'"frameborder="0" allowfullscreen></iframe>');
        $scope.title=heading;
        console.log($scope.title);
    };

}]);
