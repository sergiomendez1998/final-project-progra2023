import { useState } from "react"
export  const RegisterNewUserModal = () => {
    const [showModal1, setShowModal1] = useState(false);
    const [showModal2, setShowModal2] = useState(false);

    const handleCloseModal1 = () => setShowModal1(false);
    const handleCloseModal2 = () => setShowModal2(false);
    const handleShowModal1 = () => setShowModal1(true);
    const handleShowModal2 = () => setShowModal2(true);

    return (
       <>
           <a className="btn btn-primary" data-bs-toggle="modal" href="#exampleModalToggle" role="button">
               Open first modal
           </a>

           <div className={`modal fade ${showModal1 ? 'show' : ''}`} id="exampleModalToggle" aria-hidden={!showModal1} tabIndex="-1">
               <div className="modal-dialog modal-dialog-centered">
                   <div className="modal-content">
                       <div className="modal-header">
                           <h5 className="modal-title" id="exampleModalToggleLabel">Modal 1</h5>
                           <button type="button" className="btn-close" data-bs-dismiss="modal" aria-label="Close" onClick={handleCloseModal1}></button>
                       </div>
                       <div className="modal-body">
                           Show a second modal and hide this one with the button below.
                       </div>
                       <div className="modal-footer">
                           <button className="btn btn-primary" data-bs-target="#exampleModalToggle2" data-bs-toggle="modal" data-bs-dismiss="modal" onClick={handleShowModal2}>
                               Open second modal
                           </button>
                       </div>
                   </div>
               </div>
           </div>

           <div className={`modal fade ${showModal2 ? 'show' : ''}`} id="exampleModalToggle2" aria-hidden={!showModal2} tabIndex="-1">
               <div className="modal-dialog modal-dialog-centered">
                   <div className="modal-content">
                       <div className="modal-header">
                           <h5 className="modal-title" id="exampleModalToggleLabel2">Modal 2</h5>
                           <button type="button" className="btn-close" data-bs-dismiss="modal" aria-label="Close" onClick={handleCloseModal2}></button>
                       </div>
                       <div className="modal-body">
                           Hide this modal and show the first with the button below.
                       </div>
                       <div className="modal-footer">
                           <button className="btn btn-primary" data-bs-target="#exampleModalToggle" data-bs-toggle="modal" data-bs-dismiss="modal" onClick={handleShowModal1}>
                               Back to first
                           </button>
                       </div>
                   </div>
               </div>
           </div>
       </>
    )
}