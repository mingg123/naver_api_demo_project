import React, { useState } from "react";
import { TextField } from "@material-ui/core";
import axios from "axios";
const AxiosExample = () => {
  const [value, setValue] = useState("");
  const [data, setData] = useState(null);

  const onClick = async () => {
    try {
      const response = await axios.get(
        `http://localhost:8083/api/shopping/search?query=` + value
      );
      setData(response.data);
    } catch (e) {
      console.log(e);
    }
  };
  return (
    <div>
      <div>
        <TextField
          value={value}
          onChange={(e) => {
            setValue(e.target.value);
          }}
        />
        <button onClick={onClick}>불러오기</button>
      </div>
      {data && (
        <textarea
          rows={7}
          value={JSON.stringify(data, null, 2)}
          readOnly={true}
        />
      )}
    </div>
  );
};
export default AxiosExample;
