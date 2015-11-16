angular.module('timetable',[]);
angular.module('timetable').controller('timetableController',function($scope,$http){
    
    
    
    $scope.timetable = {};
    
    
    
    $scope.save = function(){
        $http.post('/savetimetable',$scope.timetable).success(getSuccess()).error(getError());
    };
    
    
    
    
    $scope.delTimetable= {};
    $scope.deleteTimetable = function (){
        $http.post('/deletetimetable',$scope.timetable).success(getSuccess()).error(getError());
    };
    
    
    $scope.delTimetable = function (rowtimetable) {
        $http.post('/deletetimetable', rowtimetable).success(function (data) {
            getTimetable();
        }).error(function (data) {
            alert('ลบไม่สำเร็จ');
        });
    };
    
    
    getTimetable();
    
    
    
    $scope.timetableshow = {};
        function getTimetable(){
            $http.get('/gettimetable').success(function(data){
                $scope.timetabletshow = data;
            }).error(function(data){
                
            });
        };
    
    
    
    
    $scope.clickUpdate = function(updateTimetable){
        $scope.timetable = updateTimetable;
    };
    
    
    
    function getSuccess(){
        alert('Save Success');
    }
    function getError(){
        alert('Error');
    }
});