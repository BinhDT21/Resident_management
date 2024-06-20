import axios from 'axios';
import React, { useState } from 'react';

const PaymentForm = () => {
    const [amount, setAmount] = useState('10000'); // Ví dụ số tiền cố định
    const [qrCodeUrl, setQrCodeUrl] = useState('');

const handlePayment = async () => {
    try {
        const response = await axios.post('/api/payment/momo', {
        orderId: 'orderId',
        requestId: 'requestId',
        amount: amount
        });
        const data = JSON.parse(response.data);
      setQrCodeUrl(data.qrCodeUrl); // URL của QR code
    } catch (error) {
        console.error('Payment error', error);
    }
};

return (
        <div>
        <h3>Số tiền: {amount} VND</h3>
        <button onClick={handlePayment}>Lấy QR Code</button>
        {qrCodeUrl && <img src={qrCodeUrl} alt="MoMo QR Code" />}
        </div>
    );
};

export default PaymentForm;
