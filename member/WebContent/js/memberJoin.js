
//0-1. 정규식 통과 메서드
		function regpass(target){
			
			
			span = $(target).parents('.form-group').find('.sp');
			
			$(span).empty();
			
			
			$('<img>',{
				
				'src' : '/jqpro/images/check.png',
				'width' : '20px',
				'height' : '20px'
					
					
			}).appendTo(span);
			
			$(target).parents('.form-group').find('.msg').html("");
			
			
		}
//0-2. 정규식 실패 메서드
		function regfail(target,text){
			
			
			span = $(target).parents('.form-group').find('.sp');
			
			$(span).empty();
			
			
			$(target).parents('.form-group').find('.msg').html(text).css('color','red');
			return false;
		}

	

//1. 정규식 체크

//1-1 아이디 정규식
		$('#mem_id').on('keyup',function(){
			
				idVal = $('#mem_id').val().trim();
				
				
				//영문 대문자 또는 소문자 또는 숫자로 시작하는 아이디, 길이는 5~15자, 끝날때 영문 대문자 또는 소문자 또는 숫자
				idReg =  /^[A-za-z0-9]{5,15}$/;
				
				if(!(idReg.test(idVal))){
					regfail(this, "올바른 형식이 아닙니다");
				}else{
					regpass(this);
				}
		})//ID keyup
		
//1-2 비밀번호 정규식
		$('#mem_pass').on('keyup',function(){
			
			passVal = $('#mem_pass').val().trim();
			
			
			//최소 8 자, 최소 하나의 문자, 하나의 숫자 및 하나의 특수 문자 
			passReg =  /^(?=.*[A-Za-z])(?=.*\d)(?=.*[^$@$!%*#?&])[A-Za-z\d$@$!%*^#?&]{8,}$/;

			
			if(!(passReg.test(passVal))){
				regfail(this, "올바른 형식이 아닙니다");
			}else{
				regpass(this);
			}
		})//keyup
		
//1-2-2 비밀번호 확인 
		$('#chk_pass').on('keyup',function(){
		
			chkVal = $(this).val().trim();
			
			if(chkVal != passVal){
				regfail(this, "비밀번호가 일치하지 않습니다")
			}else{
				regpass(this)
			}
		})
		
		
		
//1-3 이름 정규식
		$('#mem_name').on('keyup',function(){
			
			nameVal = $('#mem_name').val().trim();
			
			
			
			nameReg =  /^[가-힣]{2,4}$/;
				
			
			
			if(!(nameReg.test(nameVal))){
				regfail(this, "올바른 형식이 아닙니다");
			}else{
				regpass(this);
			}
		})//keyup
		
//1-4 전화번호 정규식 체크
		$('#mem_hp').on('keyup',function(){
			
			hpVal = $('#mem_hp').val().trim();
			
			
			
			hpReg =  /^\d{3}-\d{3,4}-\d{4}$/;
			
			if(!(hpReg.test(hpVal))){
				regfail(this, "올바른 형식이 아닙니다");
			}else{
				regpass(this);
			}
		})// keyup
		
		
		
//1-5 메일 정규식 체크
		$('#mem_mail').on('keyup',function(){
			
			mailVal = $('#mem_mail').val().trim();
			
			mailReg =  /^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$/i;

			if(!(mailReg.test(mailVal))){
				regfail(this, "올바른 형식이 아닙니다");
			}else{
				regpass(this);
			}
		})// keyup

		
//1-6 생년월일 정규식 체크
		$('#mem_bir').on('change',function(){
			
			birth = $(this).val().substring(0,4);
			
			now = new Date().getFullYear();
			
			checkBir = now - birth;
			
			if(checkBir > 10){
				
				regpass(this);
				
			}else{
				regfail(this, "10살 이상만 가입됩니다")
			}
			
			
		})
		

//2. ID 중복 체크

		
		$('#btnID').on('click',function(){
			
			if(idVal.length <1){
				alert("id를 입력 해 주세요")
				return false;
			}
		$.getJSON(
			'/member/CheckID.do', //url
			{'id' : idVal}, //data
	
			function(res){
				$('#spID').html(res.sw).css('color','red');
			}
		)
			
			
			
		})//btnID click


//4.우편번호 검색
		
		$('#btnZip').on('click',function(){
			
			dongVal = $('#dong').val().trim();
			
			$.ajax({
				
				url : '/member/selectZip.do',
				data : {'dong' : dongVal},
				Type : 'post',
				success : function(res){
					$('#result1').html(res);
				},
				error : function(req){
					alert("상태 : " + req.status)
				},
				dataType : 'html'
				
				
			})//ajax
			
		})//btnZip
		
		$('#result1').on('click',function(){
			zipcode =$('td:eq(0)',this).text();
			addr = $('td:eq(1)',this).text();
			
		    $('#zip').val(zipcode);
		    $('#add1').val(addr);
		    
			$('#myModal').modal('hide');
		})
				
				
				$('#myModal').on('hide.bs.modal',function(){
					
					$('#dong').val(""); 
					$('#result1').empty(); 
					
		})

//5.제출


		
		$('#btnJoin').on('click',function(){
			
			console.log($('#form').serialize());
			console.log($('#form').serializeArray());
			console.log($('#form').serializeJSON());
			
			$.ajax({
				url :'/jqpro/insert.do',
				type : 'post',
				data : $('#form').serializeArray(),
				success : function(res){
					$('#spjoin').html(res.sw).css('color','red');
					$('#btnreset').hide();
					
					
				},
				error : function(req){
					alert("상태 : "+ req.status);
				},
				dataType : 'json'
				
				
			})//ajax
			
		})
		