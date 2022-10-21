import React from 'react'
import "./../styling/footer.css";
 

export default function App() {
  return (
    <>
    <div className='bottom'></div>
      <footer
        style={{
          position: "fixed",
          left: 0,
          bottom: 0,
          right: 0,
        }}
      >© 2022 Auto Insurance Company | All Rights Reserved
      </footer>
    </>
  );
}