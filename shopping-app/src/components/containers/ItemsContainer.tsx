import React from "react";
import { connect } from "react-redux";
import AxiosExample from "../AxiosExample";
import { changeInput } from "../modules/items";
import ShoppingMainComponent from "../ShoppingMainComponent";
const ItemsContainer = ({ input, changeInput }) => {
  return (
    <AxiosExample input={input} onChangeInput={changeInput} />
    // <ShoppingMainComponent
    //   input={input}
    //   //   items={items}
    //   onChangeInput={changeInput}
    // />
  );
};

export default connect(
  ({ items }) => ({
    input: items.input,
  }),
  {
    changeInput,
  }
)(ItemsContainer);
