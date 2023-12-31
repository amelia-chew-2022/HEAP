import { Fragment } from "react";

const HeadingTwo = ({ children = "Heading Two", addButton = false }) => {
    return (
        <Fragment>
            <span
                style={{
                    color: "#1E56A0",
                    fontFamily: "Cocogoose",
                    fontSize: "1.5rem",
                }}
            >
                {children}
            </span>
        </Fragment>
    );
};

export default HeadingTwo;
