/**
 * 
 */
currentPage= 1;
hit =  0;





var writeServer = function(){
	
	
	//새로입력한 값들을 가져온다
	console.log($('#wForm').serializeArray());
	
	$.ajax({
	
		url :'/board/write.do',
		type : 'post',
		data : $('#wForm').serializeArray(),
		dataType : 'json',
		success : function(res){
			
			alert(res.sw)
			readPageServer(1);
		},
		error : function(req){
			alert("상태 : " + req.status)
		}
		
	})
	
	
	
	
	
	
}//ws

var updateServer = function(){
	
	//수정 폼에 입력한 값을 가져온다
	console.log($('#mForm').serializeArray());
	
	$.ajax({
		
		
		url : '/board/update.do',
		type : 'post',
		data : $('#mForm').serializeArray(),
		dataType : 'json',
		success : function(res){
			alert(res.sw);
//			board.writer
		},
		error : function(req){
			alert("상태 : " + req.status);
		}
		
		
	}) //ajax
	
	
	
}//us


var deleteServer = function(bonum,but){ //but ==> 삭제버튼
	
	$.ajax({
		url : '/board/delete.do',
		type : 'get',
		data : {"bonum" : bonum},
		datYpe :'json',
		success : function(res){
			alert(res.sw);
			//화면에서 지우기
			$(but).parents('.panel').remove();
		
		},
		error : function(req){
			alert(req.status);
		}
		
		
	})
	
	
	
}//ds


var readHitServer = function(bonum,list){
	
	$.ajax({
		
		url :'/board/ReadHitUpdate',
		type : 'get',
		dataType : 'json',
		data : {"bonum" : bonum},
		success :function(res){
//			hit++;	//성공해서 돌아오면 증가한다??
//			alert(res.sw);
			hit = $(list).parents('.panel').find('.hitspan').text(); //화면에 있는 값을 가져와 hit에 저장한다음
			
			
			hit = parseInt(hit)+1;
			 $(list).parents('.panel').find('.hitspan').text(hit); //hit+1한 값을 설정한다
			
		
		},
		error : function(req){
//			alert("상태 : " +req.staus)
		}
		
		
	})//ajax
	
	
}//rhs

var replyUpdateServer =function(){
	
	
	$.ajax({
		
		url : '/board/ReplyUpdate',
		type : 'post',
		data : reply, //renum cont가 들어 있는 객체 html에서 두개만 보냄
//		success :function(res){
//			alert(res.sw)
//		},
		error : function(req){
			alert("상태 : " + req.status)
		},
		dataType : 'json'
		
		
	})//ajax
	
}//rus
var replyDeleteServer = function(renum){
	
	
	$.ajax({
		
		url :'/board/Reply.do',
		data :{"renum" : renum},
		type :'get',
//		success : function(res){
//			alert("상태 : " + res.sw)
//		
//		},
		error : function(req){
			alert("상태  : " + req.status);
		}
		
		
		
		
		
	})//ajax
	
	
	
}//rds

var replyListServer = function(bonum,but){
	
	$.ajax({
		
		url : '/board/ReplyList.do',
		data :{"bonum" : bonum},
		type :'post',
		dataType :'json',
		success : function(res){
			
			$(but).parents('.panel').find('.pbody').find('.rep').remove();
			
			repcode = "";
			
			$.each(res,function(i){
				
				repcode +=  '<div class="panel-body rep">';
				repcode += '<p style = "width:80%; float :left;">'
				repcode +=  res[i].name + '&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;';
				repcode +=   res[i].redate + '&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<br>';
				repcode += '</p>';

				repcode += '<p style = "width:20%; float :right;">'
				repcode += '<button idx ="' + res[i].renum + '" type ="button" id = "r_modify" name ="r_modify" class ="action">댓글 수정</button>';
				repcode += '<button idx ="' + res[i].renum + '" type ="button" name ="r_delete" class ="action">댓글 삭제</button>';
				repcode += '</p>';
				repcode += '<div class ="cont" style ="margin-left:20px;">' + res[i].cont + '</div>';
				
				repcode += '</div>';
				
				
			})//반복문
			
			//출력
			$(but).parents('.panel').find('.pbody').append(repcode);
		},
		error : function(req){
			alert("상태 : " + req.status);
		}
		
		
	})//ajax
	
	
}//rpls

var replySaveServer = function(but){
	
	$.ajax({
		url : '/board/Reply.do',
		data : reply,	//reply객체 - bonum, name, cont가 저장된 객체
		type : 'post',
		dataType : 'json',
		success : function(res){
//			alert(res.sw);
			replyListServer(reply.bonum,but); //bonum과 but를 replyListServer에 넘긴다
		},
		error : function(req){
			alert("상태 : " + req.status);
		}
		
			
	})//ajax
	
	
	
}//rss

var readPageServer = function(cpage){ //readPageServer가 변수이름 형태로 함수를 지정할 수 있다  --cPage는 파라미터
	
		
	$.ajax({
		url : '/board/SelectList.do',
		type : 'post',
		data : {'page' : cpage},
		dataType : 'json',
		success : function(res){
			code =' <div class="panel-group" id="accordion">';
			$.each(res.datas,function(i){
				
				code += '<div class="panel panel-default">';
				code += '<div class="panel-heading">';
				code +=  '<h4 class="panel-title">';
				code +=  '    <a name = "list" class ="subject action" idx ="'+ res.datas[i].seq + '" data-toggle="collapse" data-parent="#accordion" href="#collapse'+ res.datas[i].seq +'">'+ res.datas[i].subject +'</a>';
				code += '   </h4>';
				code +=  '</div>';
				code += '<div id="collapse'+res.datas[i].seq + '" class="panel-collapse collapse">';
				code +=  ' <div class="panel-body pbody">';
				code += '<p style = "width:80%; float :left;">'
				code += '작성자 :<span class="wspan">' + res.datas[i].writer + '</span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;';
				code += '메일 :<span class="mspan">' + res.datas[i].mail + '</span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;';
				code += '조회수 :<span class="hitspan">' + res.datas[i].hit + '</span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;';
				code += '작성날짜<span class="dspan"> : ' + res.datas[i].wdate + '</span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;';

				code += '<p style = "width:20%; float :right;">'
				code += '<button idx ="' + res.datas[i].seq + '" type ="button" name ="modify" class ="action">수정</button>';
				code += '<button idx ="' + res.datas[i].seq + '" type ="button" name ="delete" class ="action">삭제</button>';
				code += '</p><hr style = "clear:both">';
			
				code += '<p style = "width:100%;">';
				code += '<span class ="cspan">' + res.datas[i].content+ '</span>';
				code += '</p>';
			
				code += '<p style = "width:100%;">';
				code += '<textarea class ="area" cols = "60"></textarea>';
				code += '<button idx ="' + res.datas[i].seq + '" type ="button" style ="height:45px; vertical-align:top;" name ="reply" class ="action">등록</button>';
				code += '</p>';
				code +=  '  </div>';
				code +=  ' </div>';
				code += ' </div>';
			})//반복문
			
			code += '</div>';
			$('.box').html(code);
			
			
			//이전버튼 출력하기
			pager ="";
			
			$('#pageList').empty();//append할 때 empty를 안하면 계속 추가하므로 empty()를 해줘야 한다
			
			if(res.startP >1){
				pager += '<ul class="pager">';
				pager += '<li><a class ="prev" href="#">Previous</a></li>';
				 
				pager += '</ul>';
			}
			$('#pageList').append(pager);
			
			
			
			//page버튼 출력하기
			pager ='<ul class="pagination pager">';
			for(i = res.startP; i<= res.endP; i++){
				if(currentPage == i){
					pager +='<li class="active"><a  class ="paging" href="#">' + i+ '</a></li>';
				}else{
					pager +='<li><a class ="paging" href="#">' + i + '</a></li>';
				}
				 
			}
			pager +='</ul>';
			
//			$('#pageList').append(pager);
			
			
			//다음 버튼 출력하기
			
			if(res.endP <res.totalP){
				pager += '<ul class="pager">';
				
				pager += '<li><a class = "next" href="#">Next</a></li>';
				pager += '</ul>';
			}
			$('#pageList').append(pager);
			
		},
		error : function(req){
			alert("상태  : " + req.status);
		}
		
	})
	
	
	
	
}//readPage

function readServer(){
	$.ajax({
					
					url : '/board/SelectList.do',
					type :'get',
					dataType :'json',
					success : function(res){
						code =' <div class="panel-group" id="accordion">';
						$.each(res,function(i){
							
							code += '<div class="panel panel-default">';
							code += '<div class="panel-heading">';
							code +=  '<h4 class="panel-title">';
							code +=  '    <a data-toggle="collapse" data-parent="#accordion" href="#collapse'+ res[i].seq +'">'+ res[i].subject +'</a>';
							code += '   </h4>';
							code +=  '</div>';
							code += '<div id="collapse'+res[i].seq + '" class="panel-collapse collapse">';
							code +=  ' <div class="panel-body">';
							code += '<p style = "width:80%; float :left;">'
							code += '작성자 : ' + res[i].writer + '&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;';
							code += '메일 : ' + res[i].mail + '&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;';
							code += '조회수 : ' + res[i].hit + '&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;';
							code += '작성날짜 : ' + res[i].wdate + '&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;';

							code += '<p style = "width:20%; float :right;">'
							code += '<button idx ="' + res[i].seq + '" type ="button" name ="modify" class ="action">수정</button>';
							code += '<button idx ="' + res[i].seq + '" type ="button" name ="delete" class ="action">삭제</button>';
							code += '</p><hr style = "clear:both">';
						
							code += '<p style = "width:100%;">';
							code += res[i].content;
							code += '</p>';
						
							code += '<p style = "width:100%;">';
							code += '<textarea class ="area" cols = "60"></textarea>';
							code += '<button idx ="' + res[i].seq + '" type ="button" style ="height:45px; vertical-align:top;" name ="reply" class ="action">등록</button>';
							code += '</p>';
							code +=  '  </div>';
							code +=  ' </div>';
							code += ' </div>';
						})//반복문
						
						code += '</div>';
						$('.box').html(code)
						
					},
					error : function(req){
						
						alert("상태 : " + req.status)
						
					}
					
					
					
				})//ajax
				
};