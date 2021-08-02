import React from "react";
import { FC } from "react";
import "./ShoppingResultComponent.scss";
import { Route, Link } from "react-router-dom";
import { createStore } from "redux";
import { searchReducer } from "../store/reducers";
interface IShoppingResultComponent {
  data: any;
}
const ShoppingResultComponent: FC<IShoppingResultComponent> = ({ data }) => {
  return (
    <div className="root">
      {data && (
        <div>
          <div>
            <img src={data.image} width="400" height="300" />
            {data.title}
            {data.mallName}
            {/* {data.link} */}
          </div>
          <textarea
            rows={7}
            value={JSON.stringify(data, null, 2)}
            readOnly={true}
          />
        </div>
      )}
    </div>
  );
};
export default ShoppingResultComponent;
