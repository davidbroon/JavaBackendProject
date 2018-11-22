import React from 'react';

const styles = {
    headerWrapper: {
        width: '100%',
        display: 'flex',
        justifyContent: 'center',
        alignItems: 'center',
        padding: 10,
        fontSize: 30,
        border: '1px solid black',
        backgroundColor: 'black',
        color: 'white',
        fontFamily: 'Helvetica'

    }
}

const header = () => <div style={styles.headerWrapper}>Contact List</div>;

export default header;