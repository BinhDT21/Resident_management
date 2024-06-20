import { useState } from "react";
import { ListGroup } from "react-bootstrap";
import "./Payment.css";

const InvoiceDetails = ({ name, details, isOdd }) => {
    const [showDetails, setShowDetails] = useState(false);

    return (
        <ListGroup.Item
            className={`${isOdd ? "odd-item" : "even-item"}`}
            onMouseEnter={() => setShowDetails(true)}
            onMouseLeave={() => setShowDetails(false)}
        >
            <h3>{name}</h3>
            {showDetails && <p className="invoice-details">{details}</p>}
            {showDetails && <button className="invoice-details" onClick={() => alert("Thanh toán")}>Thanh toán</button>}
        </ListGroup.Item>
    );
};

export default InvoiceDetails;