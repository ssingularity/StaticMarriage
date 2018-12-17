var app=angular.module("bookstore",['ngRoute']);


app.config(['$routeProvider','$locationProvider',function ($routeProvider, $locationProvider) {
    $routeProvider
        .when('/',{
            controller:"IndexController",
            templateUrl:"index1.html"
        })
        .when('/add',{
            controller:"addcontroller",
            templateurl:"add.html"
        })
        .when('/view/:id',{
            controller:"detailcontroller",
            templateurl:"detail.html"
        })
        .otherwise({redirectTo:"/"});
}]);


app.controller("MainController",['$route','$location','$routeParams',
        function ($route, $location, $routeParams) {
            this.$route=$route;
            this.$location=$location;
            this.$routeParams=$routeParams;
}]);

app.controller("IndexController",["$scope","$routeParams","$rootScope",function ($scope,$routeParams,$rootScope) {
    $scope.init=function (n, m) {
        $.post("/init",{
            "n" : n,
            "m" : m
        },function (data) {
            $scope.$apply(function () {
                $scope.men=data.men;
                $scope.women=data.women;
            })
        });
    };
    $scope.process=function(){
        $.post("/process",null,
            function(data){
                $scope.$apply(function () {
                    $scope.men=data.men;
                    $scope.women=data.women;
                })

            })
    }
    $scope.proove=function(){
        $.post("/proove",null,
            function(data){
                $scope.$apply(function () {
                    if (data == true) {
                        alert("这的的确确是一个稳定婚姻！");
                    }
                    else {
                        alert("糟糕！有人会出轨！");
                    }
                })

            })
    }
    $scope.finish=function(){
        $.post("/finish",null,
            function(data){
                $scope.$apply(function () {
                    $scope.men=data.men;
                    $scope.women=data.women;
                })

            })
    }

}]);


jQuery(document).ready(function ($) {
    $('ul.nav > li').click(function (e) {
      $('ul.nav > li').removeClass('active');
      $(this).addClass('active');
   });
    var show_per_page=12;
    var current_page=0;
    var total_page=Math.ceil($(".mainBooks").children().length/show_per_page);

    $(".mainBooks").children().css("display","none");
    $(".mainBooks").children().slice(show_per_page*current_page,show_per_page).css("display","block");
    $(".previous").click(function(){
        if(current_page==0) return;
        else {
            --current_page;
            var start=current_page*show_per_page;
            var end=start+show_per_page;
            $(".mainBooks").children().css("display","none").slice(start,end).fadeIn("slow");
        }
    });
    $(".next").click(function(){
        if(current_page==total_page-1) return;
        else {
            ++current_page;
            var start=current_page*show_per_page;
            var end=start+show_per_page;
            $(".mainBooks").children().css("display","none").slice(start,end).fadeIn("slow");
        }
    });
});