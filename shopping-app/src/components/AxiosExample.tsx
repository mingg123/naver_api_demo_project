import React, { useState } from "react";
import { TextField } from "@material-ui/core";
import axios from "axios";
import ShoppingMainComponent from "./ShoppingMainComponent";
import ShoppingResultComponent from "./ShoppingResultComponent";
const AxiosExample = () => {
  const [value, setValue] = useState("");
  const [data, setData] = useState(null);

  return (
    <div>
      <ShoppingMainComponent setData={setData} />
      <ShoppingResultComponent data={data} />
    </div>
  );
};
export default AxiosExample;
