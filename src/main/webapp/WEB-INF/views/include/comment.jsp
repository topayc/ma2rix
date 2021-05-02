<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>

                    <div class="tabCont">
                    	<div class="commentType mb20">
	                        <span class="commetText">comment</span>
							<input type="text" name="cmt" id="cmt" style="width: 700px;" placeholder="글을 입력 하세요" onkeypress="javascript:cmt_write()">
						</div>
						<div class="mb20 oh">
							<div class="floatL" id="commentCnt"><i class="fa fa-comment"></i> <span><strong>${commentCnt}</strong> comments</span></div>
							<div class="floatR"><a href="#none" class="addLineType1 btn topayc"><span>모두보기</span></a></div>
						</div>

						<table class="tblType02 textL addTrType2" id="commentList_tb">
                            <colgroup>
                                <col style="width: 10%">
                                <col style="width: auto">
                                <col style="width: 10%">
                            </colgroup>                            
						<c:forEach var="commentList" items="${comment_list}">
                            <tr>
                                <td><img src="../resources/images/arrage/holderType3.gif" alt="" style="width: 50px; height: 50px;"></td>
                                <td class="textL">
                                	<div class="mb10"><a href="#">${comment_list.memberUserId}</a></div>
                                	<p>${comment_list.commentContents}</p>
                                </td>
                                <td>${comment_list.regDatetime}</td>
                            </tr>
						</c:forEach>
                        </table>
                        
                        
                    </div>
                    
                    
<script type="text/javascript">

function cmt_append_head(){	
	$(".tblType02").append(
			"<table class='tblType02 textL addTrType2'>" + 
			"		<colgroup>" + 
			"		<col style='width: 10%'>" + 
			"		<col style='width: auto'>" + 
			"		<col style='width: 10%'>" + 
			"</colgroup>"                						
	);
}	

function cmt_append(data){
	
	$("#commentList_tb").append(
			 "<tr>" +
			 "	<td><img src='../resources/images/arrage/holderType3.gif' alt='' style='width: 50px; height: 50px;'></td>" +
			 "	<td class='textL'>" +
			 "	<div class='mb10'><a href='#'>" + data['memberUserId'] + "</a></div>" +
			 "	<p>" + data['commentContents'] + "</p>" +
			 "	</td>" +
			 "<td>" + data['regDatetime'] + "</td>" +
			"</tr>"
		);
}

function cmt_append_bottom(){	
	$(".tblType02").append(
			 "</table>"
	);
}


</script>                    

<script type="text/javascript">
function cmt_write(){
	
	var musicClassNo=2;
	var musicNo=2;
	var commentContents=$("#cmt").val();	

	if(event.keyCode==13){
		$.ajax({           
			type : "POST",
			url : "/music/arrange/comment?musicClassNo=" + musicClassNo + "&musicNo=" + musicNo + "&commentContents=" + commentContents,
			success : function(result){
				cmt_reload();
	      		alert('댓글이 등록되었습니다.');
			},
			error : function(xhr, status, error){
	      		alert('더 이상 데이터가 없습니다.');
			}
		});	
	}
	
}


function cmt_reload(){

	var musicClassNo=2;
	var page = 1;
	var orderBy = 1;
	var url = "/music/arrange/remoteCommentList?musicClassNo=" + musicClassNo + "&orderBy=" + orderBy;

   $.getJSON(url, function(data) {

	   	//입력및 리스트 지우기.
		 $("#commentList_tb tr").empty();
		 $("#cmt").val("");

//		 cmt_append_head();

		var totalRow=0;
		
         $.each(data, function(key, state){
        	 
		  if(key=='totalPage'){
			  totalRow = state;
		  }

       	  if(key=='objects'){
       		  
      		 total_cnt = Object.keys(state).length;

       		  for(var i=0;i<total_cnt;i++){            			  
				var obj = state[i];
				cmt_append(obj);
       		  }
       	  }
       	  
         });
         
         $("#commentCnt").html("<i class='fa fa-comment'></i> <span><strong>" + totalRow + "</strong> comments</span>");        
         
//         cmt_append_bottom();
   });

}



		cmt_reload();
		

</script>




