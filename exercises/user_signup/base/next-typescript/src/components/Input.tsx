import { useEffect, useState } from "react";

import { Label } from "./Label";

import styles from "./Input.module.css";

interface BaseInputProps {
  id: string;
  label: string;
  hideLabel?: boolean;
  placeholder?: string;
  value?: string | number;
  size?: "small" | "medium";
  required?: boolean;
  onChange?: (ev: React.ChangeEvent<HTMLInputElement>) => void;
}

interface TextInputProps extends BaseInputProps {
  type?: "text" | "email";
  min?: never;
  max?: never;
}

interface NumberInputProps extends BaseInputProps {
  type: "number";
  min?: number;
  max?: number;
}

export type InputProps = NumberInputProps | TextInputProps;

export const Input = ({
  id,
  size = "medium",
  type = "text",
  label,
  value = "",
  hideLabel = false,
  required = false,
  onChange,
  ...props
}: InputProps) => {
  const [internalvalue, setInternalValue] = useState(value);

  useEffect(() => {
    setInternalValue(value);
  }, [value]);

  function handleChange(ev: React.ChangeEvent<HTMLInputElement>) {
    setInternalValue(ev.target.value);
    onChange && onChange(ev);
  }

  return (
    <div>
      <Label isHidden={hideLabel} htmlFor={id}>
        {label}
      </Label>
      <input
        className={[styles.input, styles[`input--${size}`]].join(" ")}
        onChange={handleChange}
        id={id}
        name={id}
        value={internalvalue}
        type={type}
        required={required}
        {...props}
      />
    </div>
  );
};
