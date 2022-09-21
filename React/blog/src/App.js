import './App.css';
import { useState } from 'react';

// <App></App>도 컴포넌트다.
function App() {

    let post = '맛집';
    let [글제목, 글제목변경] = useState(['메뉴 추천', '코디 추천', '영화 추천']); // State 사용시 HTML 자동 재렌더링
    let [logo, setLogo] = useState('ReactBlog'); // 잘 바뀌지 않는 이런 로고는 그냥 변수로 하는게 낫다.
    
    let [따봉, 따봉변경] = useState(0);

    // let num = [1, 2];
    // let [a, c] = [1, 2];
    // let a = num[0];
    // let c = num[1];

    // 
    return (
        <div className="App">
            <div className="black-nav">
                <h4 style={ {color : 'red', fontSize : '16px'} }>{ logo }</h4>
            </div>
            <div className="list">
                <h4 id={post}>
                    { 글제목[0] } <span onClick={ () => { 따봉변경(따봉+1) } }>👍</span> { 따봉 }
                    <button onClick={ () => {
                        let copy = [...글제목];
                        copy[0] = '여자 코트 추천';
                        글제목변경(copy)
                    } }>
                        다른거 추천 받기
                    </button>
                    <button onClick={ () => {
                        let copy2 = [...글제목];
                        copy2.sort();
                        글제목변경(copy2)
                    } }>
                        가나다순 정렬
                    </button>
                </h4>
                <p>9월 20일 발행</p>
                <h4 id={post}>{ 글제목[1] }</h4>
                <p>9월 20일 발행</p>
                <h4 id={post}>{ 글제목[2] }</h4>
                <p>9월 20일 발행</p>
            </div>

            <Modal></Modal>
            <Modal/>
        </div>
    );
}

// 하나의 태그 덩어리를 컴포넌트로 축약 가능.
// 컴포넌트 안에서 부모 태그를 병렬로 배치할 수 없다.
// 굳이 부모 태그를 병렬로 배치하려면 밖에 <></>로 하나 더 감싸는 방법이 있다.

// 컴포넌트를 만들면 좋은 3가지 경우
// 1. 반복적인 html 축약
// 2. 큰 페이지들
// 3. 자주 변경되는 것들

// 컴포넌트의 단점 : state를 갖다 쓸 때 문제가 생긴다. 다른 함수에 있기 때문.
function Modal() {
    return (
        <div className="modal">
            <h4>제목</h4>
            <p>날짜</p>
            <p>상세내용</p>
        </div>
    )
}

const Modal2 = () => {} // 에로우 함수로도 가능.

export default App;
