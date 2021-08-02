import { TextField } from "@material-ui/core";
import axios from "axios";
import React, { useState } from "react";
import { FC } from "react";
import "./ShoppingMainComponent.scss";
import ShoppingCartIcon from "@material-ui/icons/ShoppingCart";
import StorefrontIcon from "@material-ui/icons/Storefront";
import { useDispatch } from "react-redux";
import { searchReducer } from "../store/reducers";
import { actionSearch } from "../store/actions";
interface IShoppingMainComponent {
  setData: React.Dispatch<React.SetStateAction<null>>;
}
const ShoppingMainComponent: FC<IShoppingMainComponent> = ({ setData }) => {
  const [value, setValue] = useState("");
  const onClick = async () => {
    try {
      const response = await axios.get(
        `http://localhost:8084/api/recomend/shopping/search?query=` + value
      );
      dispatch(actionSearch(response.data));
      setData(response.data);
    } catch (e) {
      console.log(e);
    }
  };
  const dispatch = useDispatch();
  return (
    <div>
      <div className="root">
        <StorefrontIcon />
        <div className="title">쇼핑</div>
        <TextField
          placeholder="검색"
          value={value}
          onChange={(e) => {
            setValue(e.target.value);
            // dispatch(actionSearch(e.target.value));
          }}
        />
        <button onClick={onClick}>검색</button>
      </div>
    </div>
  );
};
export default ShoppingMainComponent;
