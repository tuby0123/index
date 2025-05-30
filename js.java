document.addEventListener("DOMContentLoaded", function () {
    const showBtn = document.getElementById("showWriteBox");
    const closeBtn = document.getElementById("closeWriteBox");
    const writeBox = document.getElementById("writeBox");
    const writeContent = document.getElementById("writeContent");
    const submitWrite = document.getElementById("submitWrite");
    const postList = document.getElementById("postList");

    // 작성창 열기
    showBtn.addEventListener("click", () => {
        writeBox.style.display = "block";
        showBtn.style.display = "none";
    });

    // 작성창 닫기
    closeBtn.addEventListener("click", () => {
        writeBox.style.display = "none";
        showBtn.style.display = "inline-block";
        writeContent.value = "";
    });

    // 글 작성 제출
    submitWrite.addEventListener("click", () => {
        const content = writeContent.value.trim();
        if (!content) {
            alert("글 내용을 입력하세요!");
            return;
        }

        // 글 요소 만들기
        const post = document.createElement("div");
        post.className = "post";
        post.innerHTML = `
            <p><strong>📄 사연글:</strong> ${content}</p>
            <div class="comments"></div>
            <input type="text" class="commentInput" placeholder="댓글을 입력하세요">
            <button class="commentSubmit">댓글 제출</button>
        `;

        postList.prepend(post); // 최신 글이 위로

        // 댓글 제출 기능
        const commentBtn = post.querySelector(".commentSubmit");
        const commentInput = post.querySelector(".commentInput");
        const commentList = post.querySelector(".comments");

        commentBtn.addEventListener("click", () => {
            const comment = commentInput.value.trim();
            if (!comment) return;
            const p = document.createElement("p");
            p.textContent = "상담사: " + comment;
            commentList.appendChild(p);
            commentInput.value = "";
        });

        // 작성창 초기화
        writeContent.value = "";
        writeBox.style.display = "none";
        showBtn.style.display = "inline-block";
    });
});
