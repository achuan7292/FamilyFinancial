//服务层
app.service('userService',function($http){
	this.findUser=function(){
		return $http.get('user/user.do');
	}
	
	this.addUser=function(user){
		return $http.post('user/register.do',user);
	}
	
	
	this.findMe=function(user){
		return $http.post('user/findeMe.do',user);
	}
	
	this.updatePassword=function(user){
		return $http.post('user/updatePassword.do',user);
	}
	
	this.updateUserInfo=function(entity){
		return $http.post('user/updateUserInfo.do',entity);
	}
});