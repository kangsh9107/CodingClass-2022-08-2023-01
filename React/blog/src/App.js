import logo from './logo.svg';
import './App.css';
import { useState } from 'react';

function App() {

    let post = '맛집';
    let [글제목, b] = useState(['메뉴 추천', '코디 추천', '영화 추천']); // State 사용시 HTML 자동 재렌더링
    let [logo, setLogo] = useState('ReactBlog'); // 잘 바뀌지 않는 이런 로고는 그냥 변수로 하는게 낫다.

    let num = [1, 2];
    let [a, c] = [1, 2];
    // let a = num[0];
    // let c = num[1];

    return (
        <div className="App">
            <div className="black-nav">
                <h4 style={ {color : 'red', fontSize : '16px'} }>{ logo }</h4>
            </div>
            <div className="list">
                <h4 id={post}>{ post }</h4>
                <p>9월 20일 발행, { 글제목[0] }</p>
                <h4 id={post}>{ post }</h4>
                <p>9월 20일 발행, { 글제목[1] }</p>
                <h4 id={post}>{ post }</h4>
                <p>9월 20일 발행, { 글제목[2] }</p>
            </div>
        </div>
    );
}

export default App;
