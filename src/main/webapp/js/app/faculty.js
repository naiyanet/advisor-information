angular.module('faculty',[]);
angular.module('faculty').controller('facultyController',function($scope,$http){
    
    
    
    $scope.faculty = {};
    
    
    
    $scope.save = function(){
        $http.post('/savefaculty',$scope.faculty).success(getSuccess()).error(getError());
    };
    
    
    
    
    $scope.delFaculty= {};
    $scope.deleteFaculty = function (){
        $http.post('/deletefaculty',$scope.faculty).success(getSuccess()).error(getError());
    };
    
    $scope.delFaculty = function (rowfaculty) {
        $http.post('/deletefaculty', rowfaculty).success(function (data) {
            getFaculty();
        }).error(function (data) {
            alert('ลบไม่สำเร็จ');
        });
    };
    
    getFaculty();
    
    
    
    $scope.facultyshow = {};
        function getFaculty(){
            $http.get('/getfaculty').success(function(data){
                $scope.facultyshow = data;
            }).error(function(data){
                
            });
        };
    
    
    
    
    $scope.clickUpdate = function(updateFaculty){
        $scope.faculty = updateFaculty;
    };
    
    
    
    function getSuccess(){
        alert('Save Success');
    }
    function getError(){
        alert('Error');
    }
});