import styles from "./Label.module.css";

export interface LabelProps {
  htmlFor: string;
  children: string;
  isHidden?: boolean;
}

export const Label = ({ children, isHidden = false, ...props }: LabelProps) => {
  return (
    <label className={[styles.label, isHidden ? styles["label--hidden"] : ""].join(" ")} {...props}>
      {children}
    </label>
  );
};
