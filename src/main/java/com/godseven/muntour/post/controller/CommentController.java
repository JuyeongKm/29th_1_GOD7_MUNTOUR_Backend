package com.godseven.muntour.post.controller;

import com.godseven.muntour.auth.MemberRepository;
import com.godseven.muntour.member.domain.Member;
import com.godseven.muntour.post.dto.CommentDto;
import com.godseven.muntour.post.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class CommentController {

    private final CommentService commentService;
    private final MemberRepository memberRepository;

    // 댓글 작성
    @PostMapping("/comments/{boardId}/{memberId}")
    public ResponseEntity<ApiResponse> writeComment(@PathVariable("boardId") Integer boardId,
                                                    @PathVariable("memberId") Long memberId,
                                                    @RequestBody CommentDto commentDto) {
        Member member = memberRepository.findById(memberId)
                .orElseThrow(() -> new RuntimeException("Member not found"));
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(new ApiResponse("성공", "댓글 작성을 완료했습니다.", commentService.writeComment(boardId, commentDto, member)));
    }

    // 게시글에 달린 댓글 모두 불러오기
    @GetMapping("/comments/{boardId}")
    public ResponseEntity<ApiResponse> getComments(@PathVariable("boardId") Integer boardId) {
        return ResponseEntity.ok(new ApiResponse("성공", "댓글을 불러왔습니다.", commentService.getComments(boardId)));
    }

    // 댓글 삭제
    @DeleteMapping("/comments/{boardId}/{commentId}")
    public ResponseEntity<ApiResponse> deleteComment(@PathVariable("boardId") Integer boardId,
                                                     @PathVariable("commentId") Integer commentId) {
        commentService.deleteComment(commentId);
        return ResponseEntity.ok(new ApiResponse("성공", "댓글 삭제 완료", null));
    }

    // ApiResponse 클래스
    private static class ApiResponse {
        private String status;
        private String message;
        private Object data;

        public ApiResponse(String status, String message, Object data) {
            this.status = status;
            this.message = message;
            this.data = data;
        }

        // Getter and Setter (lombok의 @Data를 사용할 수도 있습니다)
        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }

        public Object getData() {
            return data;
        }

        public void setData(Object data) {
            this.data = data;
        }
    }
}
