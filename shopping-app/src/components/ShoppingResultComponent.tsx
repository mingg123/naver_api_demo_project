import React from "react";
import { FC } from "react";
import "./ShoppingResultComponent.scss";
import { createStore } from "redux";
import { useDispatch } from "react-redux";
import { Store } from "@material-ui/icons";
import { useReducer } from "react";
interface IShoppingResultComponent {
  data: any;
}
const ShoppingResultComponent: FC<IShoppingResultComponent> = ({ data }) => {
  return (
    <div className="root">
      {data && (
        <div>
          <div className="data-container">
            <img src={data.image} width="400" height="300" />
            <div className="data-info">
              <div>{data.title} </div>
              <div>쇼핑몰 : {data.mallName} </div>
            </div>
          </div>
          <button onClick={(e) => {}}>구매 하기</button>
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
