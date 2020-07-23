app.controller('billController',function($scope,$controller,$http,billService,userService){
	
	$scope.result=0;
	
	//清空方法
	$scope.clear=function(){
		
		$scope.result =0; 
	}
	//计算器的add方法
	$scope.add=function(){
		
		$scope.result =$scope.cal.pre*1+$scope.cal.end*1; 
	}
	$scope.reduce=function(){
		
		$scope.result =$scope.cal.pre2-$scope.cal.end2; 
	}
	$scope.multiplication=function(){
		
		$scope.result =$scope.cal.pre3*$scope.cal.end3; 
	}
	$scope.divide=function(){
		
		$scope.result =$scope.cal.pre4/$scope.cal.end4; 
	}//计算器的方法
	
	//投资初始化
	$scope.findAllInvest=function(){
		billService.findAllInvest().success(
				function(response){
					$scope.list=response;
				}
		);
	}
	
	//投资方法
	$scope.invest=function(id){
		billService.invest(id).success(
				function(response){
					$scope.list=response;
					window.setTimeOut(location.href="../FamilyFinancial/invest.html",1000);
				}
		);
	}
	
	$scope.findMyInvest=function(id){
		billService.findMyInvest(id).success(
				function(response){
					$scope.invest=response;
				}
		);
	}
	
	$scope.searchAd=function(){
		billService.searchAd($scope.search).success(
			function(response){
				$scope.list=response;
			}
		);
	}
	
	$scope.setId=function(value){
		billService.setId(value).success(
				function(response){
					
					window.setTimeOut(location.href="../FamilyFinancial/advisory.html",1000);
				}
		);
	}
	
	$scope.selectAdById=function(){
		billService.selectAdById($scope.cid).success(
			function(response){
				$scope.advisory=response;
			}	
		);
	}
	
	$scope.findUser=function(){
		userService.findUser().success(
			function(response){
				$scope.user=response;
			}
		);
	}
	//添加账单
	
	$scope.addBill=function(){
		billService.addBill($scope.bill).success(
			function(response){
				$scope.message=response;
				alert($scope.message.message+",跳转到全部账单页面");
				window.setTimeOut(location.href="../FamilyFinancial/incomeEx.html",3000);
			}	
		);
		
	}
	
	//添加银行卡
	$scope.addCard=function(){
		billService.addCard($scope.entity).success(
				function(response){
					$scope.message=response;
					alert($scope.message.message);
					$scope.selectAllCard();
				}	
		);
		
	}
	
	$scope.searchDate=function(){
		billService.searchDate($scope.entity).success(
				function(response){
					$scope.list2=response;
				}	
		);
		
	}
	
	//查询所有银行卡
	$scope.selectAllCard=function(){
		billService.selectAllCard().success(
				function(response){
					$scope.list=response;
				}	
		);
		
	}
	
	$scope.selectAllCard2=function(){
		billService.selectAllCard().success(
				function(response){
					$scope.options=response;
				}	
		);
		
	}
	
	$scope.selectAllBill=function(){
		billService.selectAllBill().success(
				function(response){
					$scope.list2=response;
				}	
		);
		
	}
	$scope.selectCount=function(){
		billService.selectCount().success(
				function(response){
					$scope.count=response;
				}	
		);
		
	}
	
	//删除银行卡
	$scope.deleteCard=function(cid){
		billService.deleteCard(cid).success(
				function(response){
					$scope.message=response;
					$scope.selectAllCard();
				}	
		);
		
	}
	
	$scope.deleteAd=function(cid){
		billService.deleteAd(cid).success(
				function(response){
					$scope.message=response;
					$scope.selectAllAd();
				}	
		);
		
	}
	
	$scope.setBill=function(value){
		$scope.bill.bKinds=value;
	}
	
	
	//上传资讯的方法
	$scope.uploadAdvisory=function(){
		if($scope.user.uid!='001'){
			alert("您不是管理员")
		}else{
			//billservice后端访问
				billService.upload().success(
						function(response){
							$scope.message=response;
							$scope.entity.pic=$scope.message.url;
							if($scope.message.success){
								billService.uploadAdvisory($scope.entity).success(
										function(response){
											$scope.message2=response;
											alert("上传成功，将跳转到资讯界面");
											window.setTimeOut(location.href="../FamilyFinancial/index.html",3000);
										}
								);
							}
						}
						
				);
				billService.upload().error(
						alert("未选择图片")
				);
				
			}	
		}
	
	$scope.selectAllAd=function(){
		$scope.findUser();
		billService.selectAllAd().success(
			function(response){
				$scope.list=response;
			}
		);
	}
	$scope.deleteBill=function(bid){
		billService.deleteBill(bid).success(
				function(response){
					$scope.message=response;
					alert($scope.message.message)
					$scope.selectAllBill();
				}
		);
	}
});