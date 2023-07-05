import RemoveIcon from "@mui/icons-material/RemoveCircleOutline";
import TextField from "../../common/form/TextField";
import IconButton from "@mui/material/IconButton";
import { useFormContext } from "react-hook-form";

const StaffRow = ({ index = -1, removeFn = () => {} }) => {
    const {
        formState: { errors },
    } = useFormContext();

    return (
        <div
            style={{
                display: "flex",
                flexDirection: "row",
                alignItems: "center",
                gap: "1rem",
            }}
        >
            <IconButton onClick={removeFn}>
                <RemoveIcon />
            </IconButton>

            <TextField
                rules={{ required: true }}
                label="Staff Name"
                name={`staffs.${index}.name`}
                nestedError={errors.staffs?.[index]?.name}
            />
             <SingleItemDropdown
                rules={{ required: true }}
                label="Hiring Method"
                name={`staffs.${index}.hiringMethod`}
                choices={[
                    {
                        text: "Please Select a Hiring Method",
                        value: "",
                    },
                ]}
                nestedError={errors.staffs?.[index]?.hiringMethod}
            />
            <SingleItemDropdown
                rules={{ required: true }}
                label="Position"
                name={`staffs.${index}.position`}
                choices={[
                    {
                        text: "Please Select a Position",
                        value: "",
                    },
                ]}
                nestedError={errors.staffs?.[index]?.position}
            />
        </div>
    );
};