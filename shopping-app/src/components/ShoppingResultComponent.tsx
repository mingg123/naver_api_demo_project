import React from "react";
import { FC } from "react";
import "./ShoppingResultComponent.scss";
import { createStore } from "redux";
import { useDispatch } from "react-redux";
import { addCart } from "../store/actions";
import cartReducer from "../store/reducers/index";
import { Store } from "@material-ui/icons";
import { useReducer } from "react";
interface IShoppingResultComponent {
  data: any;
}
const ShoppingResultComponent: FC<IShoppingResultComponent> = ({ data }) => {
  const dispatch = useDispatch();
  return (
    <div className="root">
      {data && (
        <div>
          <div className="data-container">
            <img src={data.image} width="400" height="300" />
            {/* {data.link} */}

            {data.title}
            {data.mallName}
          </div>
          <button
            onClick={(e) => {
              dispatch(addCart(data));
            }}
          >
            구매 하기
          </button>
          {/* <textarea
            rows={7}
            value={JSON.stringify(data, null, 2)}
            readOnly={true}
          /> */}
        </div>
      )}
    </div>
  );
};
export default ShoppingResultComponent;
