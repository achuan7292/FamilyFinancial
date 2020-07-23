//服务层
app.service('billService',function($http){
	this.addBill=function(bill){
		return $http.post('bill/add.do',bill);
	}
	
	this.findAllInvest=function(){
		return $http.get('bill/findAllInvest.do');
	}
	
	//投资的方法
	this.invest=function(id){
		return $http.get('bill/invest.do?id='+id);
	}
	
	this.findMyInvest=function(){
		return $http.get('bill/findMyInvest.do');
	}
	
	this.addCard=function(entity){
		return $http.post('bill/addCard.do',entity);
	}
	
	this.selectAllCard=function(){
		return $http.get('bill/selectAllCard.do')
	}
	
	this.selectAllBill=function(entity){
		return $http.get('bill/selectAllBill.do',entity);
	}
	
	this.selectCount=function(){
		return $http.get('bill/selectCount.do');
	}
	
	this.searchDate=function(entity){
		return $http.post('bill/searchDate.do',entity);
	}
	
	this.deleteCard=function(cid){
		return $http.get('bill/deleteCard.do?cid='+cid);
	}
	
	this.deleteAd=function(cid){
		return $http.get('advisory/deleteAd.do?cid='+cid);
	}
	this.setId=function(cid){
		return $http.get('advisory/myCid.do?cid='+cid);
	}
	
	this.selectAllAd=function(){
		return $http.get('advisory/selectAll.do');
	}
	
	this.selectAdById=function(cid){
		return $http.get('advisory/selectAdById.do');
	}
	
	this.uploadAdvisory=function(entity){
		return $http.post('advisory/addAdvisory.do',entity);
	}
	
	this.deleteBill=function(bid){
		return $http.get('bill/deleteBill.do?bid='+bid);
	}
	this.searchAd=function(search){
		return $http.get('advisory/search.do?keywords='+search);
	}
	
	this.upload=function(){
		var formData = new FormData();
		//将你上传的图片转换为
		formData.append('file',file.files[0]);
		return  $http({
            url: "advisory/upload.do",
            method: "post",
            data:formData,
            transformRequest: angular.identity,
            headers : {
                'Content-Type' : undefined  //文件上传的content-type修改方式
            }
        })
    }
	
});