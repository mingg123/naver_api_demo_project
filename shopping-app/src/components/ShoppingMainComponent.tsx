import { TextField } from "@material-ui/core";
import React from "react";
import StorefrontIcon from "@material-ui/icons/Storefront";
import axios from "axios";
import "./ShoppingMainComponent.scss";

type ShoppingSearchProps = {
  value: string;
  onChange: (diff: string) => void;
  getData: (data: any) => void;
};

function ShoppingMainComponent({
  value,
  onChange,
  getData,
}: ShoppingSearchProps) {
  const onClick = async () => {
    try {
      const response = await axios.get(
        `http://localhost:8084/api/recomend/shopping/search?query=` + value
      );
      getData(response.data);
    } catch (e) {
      console.log(e);
    }
  };

  return (
    <div>
      <div className="root">
        <StorefrontIcon />
        <div className="title">쇼핑</div>
        <TextField
          placeholder="검색"
          value={value}
          onChange={(e) => {
            onChange(e.target.value);
          }}
        />
        <button onClick={onClick}>검색</button>
      </div>
    </div>
  );
}

export default ShoppingMainComponent;
