/**
 * 
 */

//2. 정규식체크  ==> 정규식.test(value)
$('#id').on('keyup',function(){
					idval = $('#id').val().trim();
						
					//4자리~12자리의
					regid =/^[a-z][a-zA-Z0-9]{3,11}$/;
					
					if(!(regid.test(idval))){
						
						//메세지 출력
// 						text.parent()
// 						text.parents().find() - : 조상을 찾고 후손을 찾는다

						regfail(this,"올바른 형식이 아닙니다");
					}else{
// 						$(this).parents('.form-group')
// 						.find('.message').html("");
						regpass(this);
						
					}//else
						
					})//keyup
					
//이름 정규식 체크 /한글 2~5
					$('#name').on('keyup',function(){
						
						
						nameval = $(this).val().trim();
						regname = /^[가-힣]{2,5}$/;
						
						
						if(!(regname.test(nameval))){
							regfail(this,"올바른 형식이 아닙니다");
							
						}else{
							regpass(this);
						}//else
						
					})	//namekeyup		
					
//비밀번호 정규식 체크 - 영문 소문자, 대문자, 특수문자, 숫자가 반드시 하나이상 씩 입력
		$('#pass').on('keyup',function(){
			
			passval = $(this).val().trim();
			
			cheakpass = /^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[$%#@!^*_~-]).{4,10}$/;
			
			if(!(cheakpass.test(passval))){
				regfail(this,"올바른 형식이 아닙니다");
			}else{
				regpass(this);
				
			}
			
		})//pass keyup
		
//pass2 pass일치비교		
		$('#passchk').on('keyup',function(){
		
			pass2val = $(this).val().trim();
			
			
			if(pass2val != passval){
				regfail(this,"일치하지 않습니다");
			
			}else{
				regpass(this);
			}
		
			
		})//pass2
		
//전화번호 \d{3}-\d{3,4}-\d{4}/
		
		$('#tel').on('keyup',function(){
			
			telNum = $(this).val().trim();
			
			checktel = /^\d{3}-\d{3,4}-\d{4}$/;
			
			if(!(checktel.test(telNum))){
				regfail(this,"올바른 형식이 아닙니다");
			}
			else{
				regpass(this);
			}
			
		})
		
//mail 123dbs @sdsjh.com
		
		$('#email').on('keyup',function(){
			
			mail = $(this).val().trim();
			
			checkmail = /^[a-zA-Z1-9]{4,10}@[a-zA-Z]{3,6}.[a-zA-Z]{2,5}$/;
			
			if(!(checkmail.test(mail))){
				regfail(this,"올바른 형식이 아닙니다");
			}
			else{
				regpass(this);
			}
			
		})
		
		
//생년월일  10살 이상
		$('#bir').on('change',function(){
		
			
			//입력한 날짜를 연도만 자른다
//			birth = $(this).val().substr(0,4);
			birth = $(this).val().substring(0,4);
			
			//현재 날짜의 년도만 가져온다
			now = new Date().getFullYear();
			
			checkBir = now - birth;
			
			if(checkBir >10){
				regpass(this);
			}else{
				regfail(this, "10살 이하만 회원가입 가능합니다");
			}
			
			
		})
		
		

					
					
					
			
					
//2-1. 정규식통과메서드
					
					function regpass(target){
						sp = $(target).parents('.form-group').find('.sp');
						$(sp).empty();
						
											
						$('<img>',{
							
							'src' : '/jqpro/images/check.png',
							'width' : '20px',
							'height' : '20px'
							
						}).appendTo(sp);
						
						$(target).parents('.form-group').find('.message').html("");
					}
//2-2. 정규식 실패메서드
					function regfail(target,text){
						//메세지 출력

						sp = $(target).parents('.form-group').find('.sp');
						$(sp).empty();
						$(target).parents('.form-group')
											.find('.message').html(text)
											.css('color','red');
											return false;
					}
				
					